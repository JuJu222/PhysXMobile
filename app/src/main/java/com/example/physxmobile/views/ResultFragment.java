package com.example.physxmobile.views;

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
import android.widget.TextView;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.QuestionsResult;
import com.example.physxmobile.viewmodels.ResultViewModel;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ResultViewModel resultViewModel = new ViewModelProvider(getActivity()).get(ResultViewModel.class);
        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(getContext());
        int topicId = getArguments().getInt("topicId");

        TextView resultAccuracyTextView = view.findViewById(R.id.resultAccuracyTextView);
        TextView resultTopicTextView = view.findViewById(R.id.resultTopicTextView);
        TextView resultTimeTakenTextView = view.findViewById(R.id.resultTimeTakenTextView);
        TextView resultCorrectAnswersTextView = view.findViewById(R.id.resultCorrectAnswersTextView);
        TextView resultTotalScoreTextView = view.findViewById(R.id.resultTotalScoreTextView);
        Button resultContinueButton = view.findViewById(R.id.resultContinueButton);

        resultViewModel.init(helper.getAccessToken());

        resultViewModel.getQuestionsResult(topicId).observe(getViewLifecycleOwner(), new Observer<QuestionsResult>() {
            @Override
            public void onChanged(QuestionsResult questionsResult) {
                resultTopicTextView.setText(questionsResult.getTopic_name());
                String temp = questionsResult.getAccuracy() + "%";
                resultAccuracyTextView.setText(temp);
                resultAccuracyTextView.setText(String.valueOf(questionsResult.getAccuracy()));
                resultTotalScoreTextView.setText(String.valueOf(questionsResult.getTotal_score()));
                temp = questionsResult.getTotal_correct() + "/" + questionsResult.getTotal_questions() + " Soal";
                resultCorrectAnswersTextView.setText(temp);
                if (questionsResult.getTotal_minutes() == 0) {
                    temp = questionsResult.getTotal_seconds() + " detik";
                } else {
                    temp = questionsResult.getTotal_minutes() + " menit " + questionsResult.getTotal_seconds() + " detik";
                }
                resultTimeTakenTextView.setText(temp);
            }
        });

        resultContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_resultFragment_to_homeFragment);
            }
        });
    }
}