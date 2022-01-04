package com.example.physxmobile.adapters;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.QuestionViewModel;
import com.example.physxmobile.viewmodels.ShopViewModel;
import com.example.physxmobile.views.FITBFragment;
import com.example.physxmobile.views.MCQFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class MCQAdapter extends RecyclerView.Adapter<MCQAdapter.ViewHolder> {
    private List<Question.Questions.Options> optionChoices;
    private int noSoal;
    private int topic;
    private List<Question.Questions> resultQuestion;
    private QuestionViewModel questionViewModel;
    NavController navController;

    public MCQAdapter(List<Question.Questions.Options> optionChoices, int noSoal, List<Question.Questions> resultQuestion, QuestionViewModel questionViewModel, int topic, NavController navController) {
        this.optionChoices = optionChoices;
        this.noSoal = noSoal;
        this.resultQuestion = resultQuestion;
        this.questionViewModel = questionViewModel;
        this.topic = topic;
        this.navController = navController;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MCQAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_question_optionmcq, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull MCQAdapter.ViewHolder holder, int position) {
        holder.row_question_choices.setText(optionChoices.get(position).getOption());
        holder.row_question_choices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = holder.row_question_choices.getText().toString();
                if (answer.equals(optionChoices.get(holder.getAdapterPosition()).getOption()) && (optionChoices.get(holder.getAdapterPosition()).getIs_correct() == 1)) {
                    Bundle bundle = new Bundle();
                    questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe((LifecycleOwner) holder.row_question_choices.getContext(), new Observer<Question>() {
                        @Override
                        public void onChanged(Question question) {
                            notifyDataSetChanged();
                        }
                    });
                    holder.openCorrectDialog();
                } else if (answer.equals(optionChoices.get(holder.getAdapterPosition()).getOption()) && (optionChoices.get(holder.getAdapterPosition()).getIs_correct() == 0)) {
                    Bundle bundle = new Bundle();
                    questionViewModel.answerQuestions(topic, resultQuestion.get(noSoal).getQuestion_id(), answer).observe((LifecycleOwner) holder.row_question_choices.getContext(), new Observer<Question>() {
                        @Override
                        public void onChanged(Question question) {
                            notifyDataSetChanged();
                        }
                    });
                    holder.openIncorrectDialog();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return optionChoices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button row_question_choices;
        Dialog dialog;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            row_question_choices = itemView.findViewById(R.id.row_question_choices);
            dialog = new Dialog(itemView.getContext());
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
                                    navController.navigate(R.id.action_MCQFragment_self, bundle);
                                    break;
                                case "fitb":
                                    navController.navigate(R.id.action_MCQFragment_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    navController.navigate(R.id.action_MCQFragment_to_TOFFragment, bundle);
                                    break;
                            }

                            Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        navController.navigate(R.id.action_MCQFragment_to_resultFragment, bundle);
                    }
                }
            });
            dialog.show();
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
                                    navController.navigate(R.id.action_MCQFragment_self, bundle);
                                    break;
                                case "fitb":
                                    navController.navigate(R.id.action_MCQFragment_to_FITBFragment, bundle);
                                    break;
                                case "tof":
                                    navController.navigate(R.id.action_MCQFragment_to_TOFFragment, bundle);
                                    break;
                            }

                            Toast.makeText(dialog.getContext(), "Soal Berikut", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        navController.navigate(R.id.action_MCQFragment_to_resultFragment, bundle);
                    }
                }
            });
            dialog.show();
        }
    }


}
