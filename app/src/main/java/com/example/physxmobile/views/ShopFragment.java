package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.physxmobile.R;
import com.example.physxmobile.adapters.ShopAvatarAdapter;
import com.example.physxmobile.adapters.ShopTitleAdapter;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.ShopItems;
import com.example.physxmobile.viewmodels.ShopViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShopViewModel shopViewModel = new ViewModelProvider(getActivity()).get(ShopViewModel.class);
        SharedPreferenceHelper helper = SharedPreferenceHelper.getInstance(getContext());
        RecyclerView shopTitleRecyclerView = view.findViewById(R.id.shopTitleRecyclerView);
        RecyclerView shopAvatarRecyclerView = view.findViewById(R.id.shopAvatarRecyclerView);

        shopViewModel.init(helper.getAccessToken());

        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), new Observer<ShopItems>() {
            @Override
            public void onChanged(ShopItems shopItems) {
                List<ShopItems.ShopItem> temp = new ArrayList<>();
                for (ShopItems.ShopItem shopItem : shopItems.getShop_items()) {
                    if (shopItem.getType().equals("title")) {
                        temp.add(shopItem);
                    }
                }
                ShopTitleAdapter shopTitleAdapter = new ShopTitleAdapter(temp, shopViewModel);
                shopTitleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                shopTitleRecyclerView.setAdapter(shopTitleAdapter);
            }
        });

        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), new Observer<ShopItems>() {
            @Override
            public void onChanged(ShopItems shopItems) {
                List<ShopItems.ShopItem> temp = new ArrayList<>();
                for (ShopItems.ShopItem shopItem : shopItems.getShop_items()) {
                    if (shopItem.getType().equals("avatar")) {
                        temp.add(shopItem);
                    }
                }
                ShopAvatarAdapter shopAvatarAdapter = new ShopAvatarAdapter(temp, shopViewModel);
                shopAvatarRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                shopAvatarRecyclerView.setAdapter(shopAvatarAdapter);
            }
        });
    }
}