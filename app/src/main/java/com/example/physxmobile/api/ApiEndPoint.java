package com.example.physxmobile.api;

import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.models.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(@Field("email") String email,
                              @Field("password") String password);

    @GET("user")
    Call<User> getUser();

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(@Field("name") String name,
                                    @Field("email") String email,
                                    @Field("password") String password,
                                    @Field("password_confirmation") String password_confirmation,
                                    @Field("username") String username,
                                    @Field("school") String school,
                                    @Field("city") String city,
                                    @Field("birthyear") int birthyear);

    @POST("logout")
    Call<JsonObject> logout();
}
