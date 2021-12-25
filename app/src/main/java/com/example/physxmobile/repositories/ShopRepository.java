package com.example.physxmobile.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.api.RetrofitService;
import com.example.physxmobile.models.ShopItem;

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

    public MutableLiveData<ShopItem> getShopItems() {
        final MutableLiveData<ShopItem> shopItems = new MutableLiveData<>();

        apiService.getShopItems().enqueue(new Callback<ShopItem>() {
            @Override
            public void onResponse(Call<ShopItem> call, Response<ShopItem> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getShop_items().size());
                        shopItems.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItem> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return shopItems;
    }

    public MutableLiveData<ShopItem.ShopItemBuyResponse> buyShopItem(int shopItemId) {
        final MutableLiveData<ShopItem.ShopItemBuyResponse> shopItemBuyResponse = new MutableLiveData<>();

        apiService.buyShopItem(shopItemId).enqueue(new Callback<ShopItem.ShopItemBuyResponse>() {
            @Override
            public void onResponse(Call<ShopItem.ShopItemBuyResponse> call, Response<ShopItem.ShopItemBuyResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        shopItemBuyResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItem.ShopItemBuyResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return shopItemBuyResponse;
    }

    public MutableLiveData<ShopItem.ShopItemEquipResponse> equipShopItem(int shopItemId) {
        final MutableLiveData<ShopItem.ShopItemEquipResponse> shopItemEquipResponse = new MutableLiveData<>();

        apiService.equipShopItem(shopItemId).enqueue(new Callback<ShopItem.ShopItemEquipResponse>() {
            @Override
            public void onResponse(Call<ShopItem.ShopItemEquipResponse> call, Response<ShopItem.ShopItemEquipResponse> response) {
                Log.d(TAG, "onResponse: " + response.code());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d(TAG, "onResponse: " + response.body().getMessage());
                        shopItemEquipResponse.postValue(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<ShopItem.ShopItemEquipResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return shopItemEquipResponse;
    }
}
