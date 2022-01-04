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
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

public class TOFFragment extends Fragment {


    TextView questiontof_question, questiontof_id,questiontof_score;
    Dialog dialog;
    ImageView questiontof_image;
    Button optiontof_true, optiontof_false;
    private SharedPreferenceHelper helper;
    private QuestionViewModel questionViewModel;
    int topic, noSoal;
    List<Question.Questions> resultQuestion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_tof, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questiontof_question = view.findViewById(R.id.questiontof_question);
        questiontof_id = view.findViewById(R.id.questiontof_id);
        questiontof_score = view.findViewById(R.id.questiontof_score);
        dialog = new Dialog(view.getContext());
        questiontof_image = view.findViewById(R.id.questiontof_image);
        optiontof_true = view.findViewById(R.id.optiontof_true);
        optiontof_false = view.findViewById(R.id.optiontof_false);
        topic = getArguments().getInt("topicId");

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions(topic);
        questionViewModel.getResultQuestions().observe(getActivity(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                noSoal = getArguments().getInt("noSoal", 0);
                if (noSoal == 0) {
                    questionViewModel.clearUsersQuestionsTopic(topic);
                }
                resultQuestion = question.getQuestions();
                List<Question.Questions.Options> optionChoices = resultQuestion.get(noSoal).getOptions();

                String tof_question = resultQuestion.get(noSoal).getQuestion();
                String tof_id = "Question: " + (noSoal + 1) + "/" + resultQuestion.size();
                String tof_image = resultQuestion.get(noSoal).getImage_path();
                int tof_score = resultQuestion.get(noSoal).getScore();
                questiontof_question.setText(tof_question);
                questiontof_score.setText(String.valueOf(tof_score));
                questiontof_id.setText(tof_id);
                Glide.with(getActivity())
                        .load(tof_image)
                        .into(questiontof_image);
                questionViewModel.showQuestions(topic, resultQuestion.get(noSoal).getQuestion_id()).observe(getViewLifecycleOwner(), new Observer<Question>() {
                    @Override
                    public void onChanged(Question question) {
                    }
                });

                optiontof_false.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = optiontof_false.getText().toString();
                        if (answer.equals("False") && optionChoices.get(0).isTrue_or_false() == 0) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openCorrectDialog();
                        } else if (answer.equals("False") && optionChoices.get(0).isTrue_or_false() == 1) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openIncorrectDialog();
                        }
                    }
                });

                optiontof_true.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = optiontof_true.getText().toString();
                        if (answer.equals("True") && optionChoices.get(0).isTrue_or_false() == 1) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openCorrectDialog();
                        } else if (answer.equals("True") && optionChoices.get(0).isTrue_or_false() == 0) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openIncorrectDialog();
                        }
                    }
                });
            }
        });
    }

    private void openIncorrectDialog() {
        dialog.setContentView(R.layout.wrong_dialog);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button wrong_next = dialog.findViewById(R.id.wrong_next);
        if (resultQuestion.size() == noSoal + 1) {
            wrong_next.setText(R.string.finishquiz);
        }
        wrong_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Bundle bundle = new Bundle();
                bundle.putInt("noSoal", noSoal + 1);
                bundle.putInt("topicId", topic);
                if (noSoal + 1 < resultQuestion.size()) {
                    if (resultQuestion.get(noSoal + 1) != null) {
                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                            case "mcq":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                break;
                            case "fitb":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                break;
                            case "tof":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_self, bundle);
                                break;
                        }

                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_resultFragment, bundle);
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
        if (resultQuestion.size() == noSoal + 1) {
            correct_next.setText(R.string.finishquiz);
        }
        correct_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Bundle bundle = new Bundle();
                bundle.putInt("noSoal", noSoal + 1);
                bundle.putInt("topicId", topic);
                if (noSoal + 1 < resultQuestion.size()) {
                    if (resultQuestion.get(noSoal + 1) != null) {
                        switch (resultQuestion.get(noSoal + 1).getQuestion_type()) {
                            case "mcq":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_MCQFragment, bundle);
                                break;
                            case "fitb":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_FITBFragment, bundle);
                                break;
                            case "tof":
                                Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_self, bundle);
                                break;
                        }

                        Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Navigation.findNavController(getView()).navigate(R.id.action_TOFFragment_to_resultFragment, bundle);
                }
            }
        });
        dialog.show();
    }
}