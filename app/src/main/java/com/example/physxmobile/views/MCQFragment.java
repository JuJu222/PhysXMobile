package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.adapters.MCQAdapter;
import com.example.physxmobile.adapters.ShopAvatarAdapter;
import com.example.physxmobile.helpers.Const;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.QuestionViewModel;

import java.util.ArrayList;
import java.util.List;

public class MCQFragment extends Fragment {

    TextView questionmcq_question, questionmcq_id, questionmcq_score;
    ImageView questionmcq_image;
    private RecyclerView recyclerView;
    private SharedPreferenceHelper helper;
    private QuestionViewModel questionViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_mcq, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionmcq_question = view.findViewById(R.id.questionmcq_question);
        questionmcq_id = view.findViewById(R.id.questionmcq_id);
        questionmcq_image = view.findViewById(R.id.questionmcq_image);
        questionmcq_score = view.findViewById(R.id.questionmcq_score);
        recyclerView = view.findViewById(R.id.optionmcq_choices);
        int topic = getArguments().getInt("topicId");

        questionViewModel = new ViewModelProvider(getActivity()).get(QuestionViewModel.class);
        helper = SharedPreferenceHelper.getInstance(getContext());
        questionViewModel.init(helper.getAccessToken());
        questionViewModel.getQuestions(topic);
        questionViewModel.getResultQuestions().observe(getActivity(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                int noSoal = getArguments().getInt("noSoal",0);
                List<Question.Questions> resultQuestion = question.getQuestions();
                List<Question.Questions.Options> optionChoices = resultQuestion.get(noSoal).getOptions();
                if(question == null){
                    questionmcq_question.setText("Unknown");
                    questionmcq_id.setText("Unknown");
                }else{
                    String mcq_question = resultQuestion.get(noSoal).getQuestion();
                    String mcq_id = "Question: " + (noSoal + 1) + "/" + resultQuestion.size();
                    String mcq_image = resultQuestion.get(noSoal).getImage_path();
                    int mcq_score = resultQuestion.get(noSoal).getScore();
                    questionmcq_question.setText(mcq_question);
                    questionmcq_score.setText(String.valueOf(mcq_score));
                    questionmcq_id.setText(mcq_id);
                    Glide.with(getActivity())
                            .load(mcq_image)
                            .into(questionmcq_image);

                    questionViewModel.showQuestions(topic,resultQuestion.get(noSoal).getQuestion_id()).observe(getViewLifecycleOwner(), new Observer<Question>() {
                        @Override
                        public void onChanged(Question question) {}
                    });
                }

                //Passing ke Adapter
                MCQAdapter mcqAdapter = new MCQAdapter(optionChoices,noSoal,resultQuestion,questionViewModel,topic, Navigation.findNavController(view));
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(mcqAdapter);
            }
        });
    }
}