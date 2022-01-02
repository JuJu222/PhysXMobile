package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.QuestionsResult;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.repositories.ResultRepository;
import com.example.physxmobile.repositories.ShopRepository;

public class ResultViewModel extends AndroidViewModel {
    private ResultRepository resultRepository;
    private static final String TAG = "ShopViewModel";

    public ResultViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        resultRepository = ResultRepository.getInstance(token);
    }

    private MutableLiveData<QuestionsResult> questionsResult = new MutableLiveData<>();
    public LiveData<QuestionsResult> getQuestionsResult(int topicId) {
        questionsResult = resultRepository.getQuestionsResult(topicId);
        return questionsResult;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        resultRepository.resetInstance();
    }
}
