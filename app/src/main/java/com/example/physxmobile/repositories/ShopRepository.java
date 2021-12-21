package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.ShopItems;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopRepository {
    private static ShopRepository shopRepository;
    private RetrofitService apiService;
    private static final String TAG = "CourseRepository";

    private ShopRepository(String token) {
        Log.d(TAG, "token: " + token);
        apiService = RetrofitService.getInstance(token);
    }

    public static ShopRepository getInstance(String token) {
        if (shopRepository == null) {
            shopRepository = new ShopRepository(token);
        }

        return shopRepository;
    }

    public synchronized void resetInstance() {
        if (shopRepository != null) {
            shopRepository = null;
        }
    }

    public MutableLiveData<ShopItems> getShopItems() {
        final MutableLiveData<ShopItems> shopItems = new MutableLiveData<>();

        apiService.getShopItems().enqueue(new Callback<ShopItems>() {
            @Override
            public void onResponse(Call<ShopItems> call, Response<ShopItems> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getShop_items().size());
                        shopItems.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItems> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return shopItems;
    }

    public MutableLiveData<ShopItems.ShopItemBuyResponse> buyShopItem(int shopItemId) {
        final MutableLiveData<ShopItems.ShopItemBuyResponse> shopItemBuyResponse = new MutableLiveData<>();

        apiService.buyShopItem(shopItemId).enqueue(new Callback<ShopItems.ShopItemBuyResponse>() {
            @Override
            public void onResponse(Call<ShopItems.ShopItemBuyResponse> call, Response<ShopItems.ShopItemBuyResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        shopItemBuyResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItems.ShopItemBuyResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return shopItemBuyResponse;
    }
}
