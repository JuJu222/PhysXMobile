package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.History;
import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.UserModel;
import com.example.physxmobile.repositories.HistoryRepository;
import com.example.physxmobile.repositories.QuestionRepository;

import java.util.ArrayList;

public class HistoryViewModel extends AndroidViewModel {

    private HistoryRepository historyRepository;
    private static final String TAG = "HistoryViewModel";

    public HistoryViewModel(@NonNull Application application) { super(application); }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        historyRepository = HistoryRepository.getInstance(token);
    }

    private MutableLiveData<History> history = new MutableLiveData<>();
    public LiveData<History> getHistory() {
        history = historyRepository.getHistory();
        return history;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        historyRepository.resetInstance();
    }

}
