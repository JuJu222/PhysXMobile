package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.ClearUsersQuestionsTopicResponse;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.ShopItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionRepository {
    private static QuestionRepository questionRepository;
    private RetrofitService apiService;
    private static final String TAG = "QuestionRepository";

    private QuestionRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static QuestionRepository getInstance(String token) {
        if (questionRepository == null) {
            questionRepository = new QuestionRepository(token);
        }

        return questionRepository;
    }

    public synchronized void resetInstance() {
        if (questionRepository != null) {
            questionRepository = null;
        }
    }

    public MutableLiveData<Question> getQuestions(int topicId) {
        final MutableLiveData<Question> questions = new MutableLiveData<>();

        apiService.getQuestions(topicId).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getQuestions().size());
                        questions.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return questions;
    }

    public MutableLiveData<Question> showQuestions(int topicId, int questionId){
        final MutableLiveData<Question> showquestions = new MutableLiveData<>();

        apiService.showQuestions(topicId,questionId).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        showquestions.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
        return showquestions;
    }

    public MutableLiveData<Question> answerQuestions(int topicId, int questionId,String choice) {
        final MutableLiveData<Question> answerquestions = new MutableLiveData<>();

        apiService.answerQuestions(topicId,questionId,choice).enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        answerquestions.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return answerquestions;
    }

    public MutableLiveData<ClearUsersQuestionsTopicResponse> clearUsersQuestionsTopic(int topicId) {
        final MutableLiveData<ClearUsersQuestionsTopicResponse> clearUsersQuestionsTopic = new MutableLiveData<>();

        apiService.clearUsersQuestionsTopic(topicId).enqueue(new Callback<ClearUsersQuestionsTopicResponse>() {
            @Override
            public void onResponse(Call<ClearUsersQuestionsTopicResponse> call, Response<ClearUsersQuestionsTopicResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        clearUsersQuestionsTopic.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ClearUsersQuestionsTopicResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return clearUsersQuestionsTopic;
    }
}
