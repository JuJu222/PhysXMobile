package com.example.physxmobile.views;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.repositories.AuthRepository;

public class RegisterViewModel extends AndroidViewModel {
    private AuthRepository authRepository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance();
    }

    public MutableLiveData<RegisterResponse> register(String name, String email, String password,
                                                        String password_confirmation, String username,
                                                        String school, String city, int birthyear) {
        return authRepository.register(name, email, password, password_confirmation, username,
                school, city, birthyear);
    }
}
