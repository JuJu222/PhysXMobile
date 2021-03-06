package com.example.physxmobile.views;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

public class FITBFragment extends Fragment {

    TextView questionfitb_question, questionfitb_id,questionfitb_score;
    EditText optionfitb_answer;
    Button optionfitb_submit;
    Dialog dialog;
    ImageView questionfitb_image;
    private SharedPreferenceHelper helper;
    private QuestionViewModel questionViewModel;
    int topic;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_fitb, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionfitb_question = view.findViewById(R.id.questionfitb_question);
        questionfitb_id = view.findViewById(R.id.questionfitb_id);
        questionfitb_score = view.findViewById(R.id.questiontof_score);
        questionfitb_image = view.findViewById(R.id.questionfitb_image);
        optionfitb_answer = view.findViewById(R.id.optionfitb_answer);
        optionfitb_submit = view.findViewById(R.id.optionfitb_submit);
        dialog = new Dialog(view.getContext());
        NestedScrollView questionfitb_nestedscrollview = view.findViewById(R.id.questionfitb_nestedscrollview);
        ProgressBar fitbProgressBar = view.findViewById(R.id.fitbProgressBar);
        topic = getArguments().getInt("topicId");

        fitbProgressBar.setVisibility(View.VISIBLE);
        questionfitb_nestedscrollview.setVisibility(View.GONE);

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions(topic);
        questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                int noSoal = getArguments().getInt("noSoal", 0);
                if (noSoal == 0) {
                    questionViewModel.clearUsersQuestionsTopic(topic);
                }
                List<Question.Questions> resultQuestion = question.getQuestions();
                List<Question.Questions.Options> optionChoices = resultQuestion.get(noSoal).getOptions();
                String fitb_question = resultQuestion.get(noSoal).getQuestion();
                String fitb_id = "Question: " + (noSoal + 1) + "/" + resultQuestion.size();
                String fitb_image = resultQuestion.get(noSoal).getImage_path();
                int fitb_score = resultQuestion.get(noSoal).getScore();
                questionfitb_question.setText(fitb_question);
                questionfitb_score.setText(String.valueOf(fitb_score));
                questionfitb_id.setText(fitb_id);
                if (fitb_image != null) {
                    Glide.with(getActivity())
                            .load(fitb_image)
                            .into(questionfitb_image);
                } else {
                    questionfitb_image.setVisibility(View.INVISIBLE);
                    final float scale = getResources().getDisplayMetrics().density;
                    int dpWidthInPx  = (int) (300 * scale);
                    int dpHeightInPx = (int) (200 * scale);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpWidthInPx, dpHeightInPx);
                    questionfitb_image.setLayoutParams(layoutParams);
                }
                fitbProgressBar.setVisibility(View.GONE);
                questionfitb_nestedscrollview.setVisibility(View.VISIBLE);
                questionViewModel.showQuestions(topic, resultQuestion.get(noSoal).getQuestion_id());
                optionfitb_submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answer = optionfitb_answer.getText().toString();

                        if (answer.equals(optionChoices.get(0).getAnswer())) {
                            questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe(getViewLifecycleOwner(), new Observer<Question>() {
                                @Override
                                public void onChanged(Question question) {
                                    notify();
                                }
                            });
                            openCorrectDialog();
                        } else if(!answer.equals(optionChoices.get(0).getAnswer())){
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
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_self, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_TOFFragment, bundle);
                                                break;
                                        }

                                    }
                                } else {
                                    Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_resultFragment, bundle);
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
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_MCQFragment, bundle);
                                                break;
                                            case "fitb":
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_self, bundle);
                                                break;
                                            case "tof":
                                                Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_TOFFragment, bundle);
                                                break;
                                        }

                                    }
                                } else {
                                    Navigation.findNavController(getView()).navigate(R.id.action_FITBFragment_to_resultFragment, bundle);
                                }
                            }
                        });
                        dialog.show();
                    }
                });

            }
        });
    }
}