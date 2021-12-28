package com.example.physxmobile.api;

import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.models.UserModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndPoint {
    @POST("login")
    @FormUrlEncoded
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password);

    @GET("user")
    Call<UserModel> getUser();

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

    @POST("shop/buy/{id}")
    Call<ShopItem.ShopItemBuyResponse> buyShopItem(
            @Path("id") int shopItemId
    );

    @POST("shop/equip/{id}")
    Call<ShopItem.ShopItemEquipResponse> equipShopItem(
            @Path("id") int shopItemId
    );
}
