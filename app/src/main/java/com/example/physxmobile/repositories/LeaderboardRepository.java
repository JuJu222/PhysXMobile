package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.LeaderboardModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderboardRepository {
    private static LeaderboardRepository leaderboardRepository;
    private RetrofitService apiService;
    private static final String TAG = "LeaderboardRepository";

    private LeaderboardRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static LeaderboardRepository getInstance(String token) {
        if (leaderboardRepository == null) {
            leaderboardRepository = new LeaderboardRepository(token);
        }

        return leaderboardRepository;
    }

    public synchronized void resetInstance() {
        if (leaderboardRepository != null) {
            leaderboardRepository = null;
        }
    }

    public MutableLiveData<LeaderboardModel> getLeaderboard() {
        final MutableLiveData<LeaderboardModel> leaderboardResponse = new MutableLiveData<>();

        apiService.getLeaderboard().enqueue(new Callback<LeaderboardModel>() {
            @Override
            public void onResponse(Call<LeaderboardModel> call, Response<LeaderboardModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getLeaderboard().size());
                        leaderboardResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<LeaderboardModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return leaderboardResponse;
    }

    public MutableLiveData<LeaderboardModel> getSpecificLeaderboard(int topicId) {
        final MutableLiveData<LeaderboardModel> leaderboardResponse = new MutableLiveData<>();

        apiService.getSpecificLeaderboard(topicId).enqueue(new Callback<LeaderboardModel>() {
            @Override
            public void onResponse(Call<LeaderboardModel> call, Response<LeaderboardModel> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getLeaderboard().size());
                        leaderboardResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<LeaderboardModel> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return leaderboardResponse;
    }
}
