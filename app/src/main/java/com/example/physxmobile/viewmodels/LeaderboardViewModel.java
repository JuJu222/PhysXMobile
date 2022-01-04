package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.repositories.LeaderboardRepository;

public class LeaderboardViewModel extends AndroidViewModel {
    private LeaderboardRepository leaderboardRepository;
    private static final String TAG = "leaderboardViewModel";

    public LeaderboardViewModel(@NonNull Application application){super(application);}

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        leaderboardRepository = LeaderboardRepository.getInstance(token);
    }

    private MutableLiveData<LeaderboardModel> specificLeaderboards = new MutableLiveData<>();
    public LiveData<LeaderboardModel> getSpecificLeaderboard(int topicId){specificLeaderboards = leaderboardRepository.getSpecificLeaderboard(topicId);
        return specificLeaderboards;
    }



    private MutableLiveData<LeaderboardModel> leaderboards = new MutableLiveData<>();
    public LiveData<LeaderboardModel> getLeaderboard(){
        leaderboards = leaderboardRepository.getLeaderboard();
        return leaderboards;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        leaderboardRepository.resetInstance();
    }
}
