package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private static AuthRepository userRepository;
    private RetrofitService apiService;
    private static final String TAG = "AuthRepository";

    private AuthRepository(){
        apiService = RetrofitService.getInstance("");
    }

    public static AuthRepository getInstance(){
        if (userRepository == null){
            userRepository = new AuthRepository();
        }
        return userRepository;
    }

    public MutableLiveData<LoginResponse> login(String email, String password){
        MutableLiveData<LoginResponse> tokenResponse = new MutableLiveData<>();

        apiService.login(email, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.code());
                    if(response.code() == 200){
                        if (response.body()!=null){
                            Log.d(TAG, "onResponse: "+response.body().getAccess_token());
                            tokenResponse.postValue(response.body());
                        }
                    }
                }else{
                    Log.d(TAG, "onResponse: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
            }
        });

        return tokenResponse;
    }

    public MutableLiveData<RegisterResponse> register(String name, String email, String password,
                                                        String password_confirmation, String username,
                                                        String school, String city, int birthyear){
        MutableLiveData<RegisterResponse> registerResponse = new MutableLiveData<>();
        apiService.register(name, email, password, password_confirmation, username, school, city,
                birthyear).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.code());
                    if(response.code() == 200){
                        if (response.body()!=null){
                            Log.d(TAG, "onResponse: "+response.body());
                            registerResponse.postValue(response.body());
                        }
                    }
                }else{
                    Log.d(TAG, "onResponse: "+response.code());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });

        return registerResponse;
    }
}
