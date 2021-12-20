package com.example.physxmobile.api;

import com.example.physxmobile.helpers.Const;
import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.models.ShopItems;
import com.example.physxmobile.models.User;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private final ApiEndPoint api;
    private static RetrofitService service;
    private static final String TAG = "RetrofitService";

    public RetrofitService(String token){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if(token.equals("")){
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build();
                return chain.proceed(request);
            });
        }else{
            client.addInterceptor(chain -> {
                Request request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Authorization", token)
                        .build();
                return chain.proceed(request);
            });
        }

        api = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build().create(ApiEndPoint.class);
    }

    public static RetrofitService getInstance(String token){
        if(service==null){
            service = new RetrofitService(token);
        }else if (!token.equals("")){
            service = new RetrofitService(token);
        }
        return service;
    }

    public Call<LoginResponse> login(String email, String password){
        return api.login(email, password);
    }

    public Call<User> getUser(){
        return api.getUser();
    }

    public Call<RegisterResponse> register(String name, String email, String password,
                                               String password_confirmation, String username,
                                               String school, String city, int birthyear) {
        return api.register(name, email, password, password_confirmation, username, school, city, birthyear);
    }

    public Call<JsonObject> logout()  {
        return api.logout();
    }

    public Call<ShopItems> getShopItems()  {
        return api.getShopItems();
    }
}
