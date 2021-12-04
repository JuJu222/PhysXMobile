package com.example.physxmobile.views;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.repositories.UserRepository;

public class LoginViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance();
    }

    public MutableLiveData<LoginResponse> login(String email, String password){
        return userRepository.login(email, password);
    }
}
