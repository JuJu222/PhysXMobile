package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.UserModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileRepository {
    private static ProfileRepository profileRepository;
    private RetrofitService apiService;
    private static final String TAG = "ProfileRepository";

    private ProfileRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ProfileRepository getInstance(String token) {
        if (profileRepository == null) {
            profileRepository = new ProfileRepository(token);
        }

        return profileRepository;
    }

    public synchronized void resetInstance() {
        if (profileRepository != null) {
            profileRepository = null;
        }
    }

    public MutableLiveData<UserModel> getUser(){
        MutableLiveData<UserModel> user = new MutableLiveData<>();

        apiService.getUser().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response.body()));
                if (response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.code());
                    if(response.code() == 200){
                        if (response.body()!=null){
                            Log.d(TAG, "onResponse: "+response.body().getUser().getEmail());
                            user.postValue(response.body());
                        }
                    }
                }else{
                    Log.d(TAG, "onResponse: "+response.code());
                    user.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getMessage());
                user.postValue(null);
            }
        });

        return user;
    }

    public MutableLiveData<UserModel.User> editUser(UserModel.User profile){
        final MutableLiveData<UserModel.User> listEditUser = new MutableLiveData<>();
        apiService.editUser(profile).enqueue(new Callback<UserModel.User>() {
            @Override
            public void onResponse(Call<UserModel.User> call, Response<UserModel.User> response) {
                Log.d(TAG, "onResponse: "+response.body());
                listEditUser.postValue(response.body());
            }

            @Override
            public void onFailure(Call<UserModel.User> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });

        return listEditUser;
    }

    public LiveData<String> logout() {
        MutableLiveData<String> message = new MutableLiveData<>();

        apiService.logout().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        try {
                            JSONObject object = new JSONObject(new Gson().toJson(response.body()));
                            String msg = object.getString("message");
                            Log.d(TAG, "onResponse: " + message);
                            message.postValue(msg);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return message;
    }
}
