package com.example.physxmobile.api;

import com.example.physxmobile.models.History;
import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.QuestionsResult;
import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.models.UserModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password);

    @GET("user")
    Call<UserModel> getUser();

    @PUT("user")
    Call<UserModel.User> editUser(@Body UserModel.User profile);

    @GET("history")
    Call<History> getHistory();

    @POST("register")
    @FormUrlEncoded
    Call<RegisterResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_confirmation") String password_confirmation,
            @Field("username") String username,
            @Field("school") String school,
            @Field("city") String city,
            @Field("birthyear") int birthyear
    );

    @GET("home")
    Call<HomeResponse> getHome();

    @POST("logout")
    Call<JsonObject> logout();

    @GET("shop")
    Call<ShopItem> getShopItems();

    @GET("questions/{topic}")
    Call<Question> getQuestions(
            @Path("topic") int topicId
    );

    @POST("shop/buy/{id}")
    Call<ShopItem.ShopItemBuyResponse> buyShopItem(
            @Path("id") int shopItemId
    );

    @POST("shop/equip/{id}")
    Call<ShopItem.ShopItemEquipResponse> equipShopItem(
            @Path("id") int shopItemId
    );

    @GET("questions/{topic}/{question}")
    Call<Question> showQuestions(
            @Path("topic") int topicId,
            @Path("question") int questionId
    );

    @POST("questions/{topic}/{question}")
    @FormUrlEncoded
    Call<Question> answerQuestions(
            @Path("topic") int topicId,
            @Path("question") int questionId,
            @Field("choice") String choice
    );
  
    @GET("result/{topic}")
    Call<QuestionsResult> getQuestionsResult(
            @Path("topic") int topicId
    );
}
