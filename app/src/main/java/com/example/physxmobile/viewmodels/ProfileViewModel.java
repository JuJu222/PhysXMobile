package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.User;
import com.example.physxmobile.repositories.ProfileRepository;

public class ProfileViewModel extends AndroidViewModel {
    private ProfileRepository profileRepository;
    private static final String TAG = "ProfileViewModel";

    public ProfileViewModel(@NonNull Application application) {
        super(application);
    }

    public void init (String token) {
        Log.d(TAG, "token: " + token);
        profileRepository = ProfileRepository.getInstance(token);
    }

    private MutableLiveData<User> user = new MutableLiveData<>();
    public LiveData<User> getUser() {
        user = profileRepository.getUser();
        return user;
    }

    public LiveData<String> logout() {
        profileRepository.resetInstance();
        return profileRepository.logout();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        profileRepository.resetInstance();
    }
}