package com.example.physxmobile.api;

import com.example.physxmobile.helpers.Const;
import com.example.physxmobile.models.ClearUsersQuestionsTopicResponse;
import com.example.physxmobile.models.History;
import com.example.physxmobile.models.HomeResponse;
import com.example.physxmobile.models.LeaderboardModel;
import com.example.physxmobile.models.LoginResponse;
import com.example.physxmobile.models.Question;
import com.example.physxmobile.models.QuestionsResult;
import com.example.physxmobile.models.RegisterResponse;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.models.UserModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;

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

    public Call<UserModel> getUser(){
        return api.getUser();
    }

    public Call<UserModel.User> editUser(UserModel.User profile){
        return api.editUser(profile);
    }

    public Call<RegisterResponse> register(String name, String email, String password,
                                               String password_confirmation, String username,
                                               String school, String city, int birthyear) {
        return api.register(name, email, password, password_confirmation, username, school, city, birthyear);
    }

    public Call<JsonObject> logout()  {
        return api.logout();
    }

    public Call<HomeResponse> getHome()  {
        return api.getHome();
    }

    public Call<ShopItem> getShopItems()  {
        return api.getShopItems();
    }

    public Call<History> getHistory(){
        return api.getHistory();
    }

    public Call<Question> getQuestions(int topicId){
        return api.getQuestions(topicId);
    }

    public Call<ShopItem.ShopItemBuyResponse> buyShopItem(int shopItemId)  {
        return api.buyShopItem(shopItemId);
    }

    public Call<ShopItem.ShopItemEquipResponse> equipShopItem(int shopItemId)  {
        return api.equipShopItem(shopItemId);
    }

    public Call<Question> showQuestions(int topicId, int questionId){
        return api.showQuestions(topicId, questionId);
    }

    public Call<Question> answerQuestions(int topicId, int questionId, String choice){
        return api.answerQuestions(topicId, questionId, choice);
    }
      
    public Call<QuestionsResult> getQuestionsResult(int topicId)  {
        return api.getQuestionsResult(topicId);
    }

    public Call<LeaderboardModel> getLeaderboard(){
        return api.getLeaderboard();
    }

    public Call<LeaderboardModel> getSpecificLeaderboard(int topicId){
        return api.getSpecificLeaderboard(topicId);
    }

    public Call<ClearUsersQuestionsTopicResponse> clearUsersQuestionsTopic(int topicId)  {
        return api.clearUsersQuestionsTopic(topicId);
    }
}
