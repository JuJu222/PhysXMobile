package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.ShopItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepository {
    private static HomeRepository homeRepository;
    private RetrofitService apiService;
    private static final String TAG = "HomeRepository";

    private HomeRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static HomeRepository getInstance(String token) {
        if (homeRepository == null) {
            homeRepository = new HomeRepository(token);
        }

        return homeRepository;
    }

    public synchronized void resetInstance() {
        if (homeRepository != null) {
            homeRepository = null;
        }
    }

    public MutableLiveData<HomeResponse> getHome() {
        final MutableLiveData<HomeResponse> homeResponse = new MutableLiveData<>();

        apiService.getHome().enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getName());
                        homeResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return homeResponse;
    }
}
