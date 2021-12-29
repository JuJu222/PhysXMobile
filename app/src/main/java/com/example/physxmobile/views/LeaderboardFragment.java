package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.physxmobile.R;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.List;

public class LeaderboardFragment extends Fragment {
    Button topik_1;
    private QuestionViewModel questionViewModel;
    private SharedPreferenceHelper helper;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        topik_1 = view.findViewById(R.id.topik_1);
        int topic = 1;
        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());
        topik_1.setOnClickListener(view1 -> {
            questionViewModel.getQuestions(topic);
            questionViewModel.getResultQuestions().observe(getViewLifecycleOwner(), new Observer<Question>() {
                @Override
                public void onChanged(Question question) {
                    List<Question.Questions> resultQuestion = question.getQuestions();
                    Bundle bundle = new Bundle();
                    bundle.putInt("noSoal", 0);
                    bundle.putInt("topicId", topic);
                    if (resultQuestion.get(0) != null) {
                        switch (resultQuestion.get(0).getQuestion_type()) {
                            case "mcq":
                                Navigation.findNavController(view1).navigate(R.id.action_leaderboardFragment_to_MCQFragment, bundle);
                                break;
                            case "fitb":
                                Navigation.findNavController(view1).navigate(R.id.action_leaderboardFragment_to_FITBFragment, bundle);
                                break;
                            case "tof":
                                Navigation.findNavController(view1).navigate(R.id.action_leaderboardFragment_to_TOFFragment, bundle);
                                break;
                        }
                    }
                }
            });
        });
    }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_leaderboard, container, false);
        }
    }
