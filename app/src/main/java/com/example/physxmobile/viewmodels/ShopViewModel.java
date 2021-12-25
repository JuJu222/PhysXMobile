package com.example.physxmobile.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.repositories.ShopRepository;

public class ShopViewModel extends AndroidViewModel {
    private ShopRepository shopRepository;
    private static final String TAG = "ShopViewModel";

    public ShopViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        Log.d(TAG, "init: " + token);
        shopRepository = ShopRepository.getInstance(token);
    }

    private MutableLiveData<ShopItem> shopItems = new MutableLiveData<>();
    public LiveData<ShopItem> getShopItems() {
        shopItems = shopRepository.getShopItems();
        return shopItems;
    }

    private MutableLiveData<ShopItem.ShopItemBuyResponse> shopItemBuyResponse = new MutableLiveData<>();
    public LiveData<ShopItem.ShopItemBuyResponse> buyShopItem(int shopItemId) {
        shopItemBuyResponse = shopRepository.buyShopItem(shopItemId);
        return shopItemBuyResponse;
    }

    private MutableLiveData<ShopItem.ShopItemEquipResponse> equipShopItemResponse = new MutableLiveData<>();
    public LiveData<ShopItem.ShopItemEquipResponse> equipShopItem(int shopItemId) {
        equipShopItemResponse = shopRepository.equipShopItem(shopItemId);
        return equipShopItemResponse;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared: ");
        shopRepository.resetInstance();
    }
}
