package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.History;
import com.example.physxmobile.models.UserModel;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryRepository {
    private static HistoryRepository historyRepository;
    private RetrofitService apiService;
    private static final String TAG = "HistoryRepository";

    private HistoryRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static HistoryRepository getInstance(String token) {
        if (historyRepository == null) {
            historyRepository = new HistoryRepository(token);
        }

        return historyRepository;
    }

    public synchronized void resetInstance() {
        if (historyRepository != null) {
            historyRepository = null;
        }
    }

    public MutableLiveData<History> getHistory(){
        MutableLiveData<History> history = new MutableLiveData<>();

        apiService.getHistory().enqueue(new Callback<History>() {
            @Override
            public void onResponse(Call<History> call, Response<History> response) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.code());
                    if(response.code() == 200){
                        if (response.body()!=null){
                            Log.d(TAG, "onResponse: "+response.body().getHistories().size());
                            history.postValue(response.body());
                        }
                    }
                }else{
                    Log.d(TAG, "onResponse: "+response.code());
                    history.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<History> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
                history.postValue(null);
            }
        });

        return history;
    }
}
