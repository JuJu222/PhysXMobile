package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.repositories.HomeRepository;
import com.example.physxmobile.repositories.ShopRepository;

public class HomeViewModel extends AndroidViewModel {
    private HomeRepository homeRepository;
    private static final String TAG = "HomeViewModel";

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        homeRepository = HomeRepository.getInstance(token);
    }

    private MutableLiveData<HomeResponse> homeResponse = new MutableLiveData<>();
    public LiveData<HomeResponse> getHome() {
        homeResponse = homeRepository.getHome();
        return homeResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        homeRepository.resetInstance();
    }
}
