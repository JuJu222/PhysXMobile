package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.QuestionsResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultRepository {
    private static ResultRepository resultRepository;
    private RetrofitService apiService;
    private static final String TAG = "ResultRepository";

    private ResultRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ResultRepository getInstance(String token) {
        if (resultRepository == null) {
            resultRepository = new ResultRepository(token);
        }

        return resultRepository;
    }

    public synchronized void resetInstance() {
        if (resultRepository != null) {
            resultRepository = null;
        }
    }

    public MutableLiveData<QuestionsResult> getQuestionsResult(int topicId) {
        final MutableLiveData<QuestionsResult> questionsResult = new MutableLiveData<>();

        apiService.getQuestionsResult(topicId).enqueue(new Callback<QuestionsResult>() {
            @Override
            public void onResponse(Call<QuestionsResult> call, Response<QuestionsResult> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getAccuracy());
                        questionsResult.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<QuestionsResult> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return questionsResult;
    }
}
