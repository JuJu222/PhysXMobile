package com.example.physxmobile.views;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.helpers.Const;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

public class TOFFragment extends Fragment {


    TextView questiontof_question, questiontof_id;
    Dialog dialog;
    ImageView questiontof_image;
    Button optiontof_true, optiontof_false;
    private SharedPreferenceHelper helper;
    private QuestionViewModel questionViewModel;
    int topic = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_tof, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questiontof_question = view.findViewById(R.id.questionfitb_question);
        questiontof_id = view.findViewById(R.id.questionfitb_id);
        questiontof_image = view.findViewById(R.id.questionfitb_image);
        optiontof_true = view.findViewById(R.id.optiontof_true);
        optiontof_false = view.findViewById(R.id.optiontof_false);

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions(topic);
        questionViewModel.getResultQuestions().observe(getActivity(), showQuestionDetail);
    }

    private Observer<Question> showQuestionDetail = new Observer<Question>() {
        @Override
        public void onChanged(Question question) {
            int noSoal = getArguments().getInt("noSoal", 0);
            List<Question.Questions> resultQuestion = question.getQuestions();
            List<Question.Questions.Options> optionChoices = resultQuestion.get(noSoal).getOptions();
            if (question == null) {
                questiontof_question.setText("Unknown");
                questiontof_id.setText("Unknown");
            } else {
                String tof_question = resultQuestion.get(noSoal).getQuestion();
                String tof_id = (noSoal + 1) + "/ " + resultQuestion.size();
                String tof_image = resultQuestion.get(noSoal).getImage_path();
                questiontof_question.setText(tof_question);
                questiontof_id.setText(tof_id);
                Glide.with(getActivity())
                        .load(Const.BASE_URL + tof_image)
                        .into(questiontof_image);
                questionViewModel.showQuestions(topic, resultQuestion.get(noSoal).getQuestion_id()).observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                    }
                });

                optiontof_false.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = optiontof_true.getText().toString();
                        if (answer.equals("True") && optionChoices.get(noSoal).isTrue_or_false()) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openCorrectDialog();
                        } else if (answer.equals("True") && !optionChoices.get(noSoal).isTrue_or_false()) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openIncorrectDialog();
                        }


                    }

                    private void openIncorrectDialog() {
                        dialog.setContentView(R.layout.wrong_dialog);
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Button wrong_next = dialog.findViewById(R.id.wrong_next);
                        if (resultQuestion.size() < (noSoal + 1)) {
                            wrong_next.setText(R.string.finishquiz);
                        }
                        wrong_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("noSoal", noSoal + 1);
                                if (!(resultQuestion.size() < noSoal + 1)) {
                                    if (resultQuestion.get(noSoal + 1) != null) {
                                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                                            case "mcq":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_self, bundle);
                                                break;
                                        }

                                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    //Redirect ke result page disini
                                }
                            }
                        });
                        dialog.show();
                    }

                    private void openCorrectDialog() {
                        dialog.setContentView(R.layout.correct_dialog);
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Button correct_next = dialog.findViewById(R.id.correct_next);
                        if (resultQuestion.size() < (noSoal + 1)) {
                            correct_next.setText(R.string.finishquiz);
                        }
                        correct_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("noSoal", noSoal + 1);
                                if (!(resultQuestion.size() < noSoal + 1)) {
                                    if (resultQuestion.get(noSoal + 1) != null) {
                                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                                            case "mcq":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_self, bundle);
                                                break;
                                        }

                                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    //Redirect ke result page disini
                                }
                            }
                        });
                        dialog.show();
                    }
                });

                optiontof_true.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = optiontof_true.getText().toString();
                        if (answer.equals("True") && optionChoices.get(noSoal).isTrue_or_false()) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openCorrectDialog();
                        } else if (answer.equals("True") && !optionChoices.get(noSoal).isTrue_or_false()) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openIncorrectDialog();
                        }
                    }

                    private void openIncorrectDialog() {
                        dialog.setContentView(R.layout.wrong_dialog);
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Button wrong_next = dialog.findViewById(R.id.wrong_next);
                        if (resultQuestion.size() < (noSoal + 1)) {
                            wrong_next.setText(R.string.finishquiz);
                        }
                        wrong_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("noSoal", noSoal + 1);
                                if (!(resultQuestion.size() < noSoal + 1)) {
                                    if (resultQuestion.get(noSoal + 1) != null) {
                                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                                            case "mcq":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_self, bundle);
                                                break;
                                        }

                                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    //Redirect ke result page disini
                                }
                            }
                        });
                        dialog.show();
                    }

                    private void openCorrectDialog() {
                        dialog.setContentView(R.layout.correct_dialog);
                        dialog.setCancelable(false);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Button correct_next = dialog.findViewById(R.id.correct_next);
                        if (resultQuestion.size() < (noSoal + 1)) {
                            correct_next.setText(R.string.finishquiz);
                        }
                        correct_next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("noSoal", noSoal + 1);
                                if (!(resultQuestion.size() < noSoal + 1)) {
                                    if (resultQuestion.get(noSoal + 1) != null) {
                                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                                            case "mcq":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(view).navigate(R.id.action_TOFFragment_self, bundle);
                                                break;
                                        }

                                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    //Redirect ke result page disini
                                }
                            }
                        });
                        dialog.show();
                    }
                });
            }
        }
    };

}