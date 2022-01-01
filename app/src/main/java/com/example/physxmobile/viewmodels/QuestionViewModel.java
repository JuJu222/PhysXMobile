package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.repositories.QuestionRepository;
import com.example.physxmobile.repositories.ShopRepository;

public class QuestionViewModel extends AndroidViewModel {
    private QuestionRepository questionRepository;
    private static final String TAG = "QuestionViewModel";

    public QuestionViewModel(@NonNull Application application){super(application);}

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        questionRepository = QuestionRepository.getInstance(token);
    }
    private MutableLiveData<Question> questions = new MutableLiveData<>();
    public void getQuestions(int topicId) {
        questions = questionRepository.getQuestions(topicId);
    }

    public LiveData<Question> getResultQuestions(){
      return questions;
    }

    private MutableLiveData<Question> showQuestions = new MutableLiveData<>();
    public LiveData<Question> showQuestions(int topicId, int questionId){
        showQuestions = questionRepository.showQuestions(topicId, questionId);
        return showQuestions;
    }

    private MutableLiveData<Question> answerQuestions = new MutableLiveData<>();
    public LiveData<Question> answerQuestions(int topicId, int questionId, String choice){
        answerQuestions = questionRepository.answerQuestions(topicId, questionId,choice);
        return answerQuestions;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        questionRepository.resetInstance();
    }
}
