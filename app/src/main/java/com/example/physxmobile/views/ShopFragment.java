package com.example.physxmobile.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.physxmobile.R;
import com.example.physxmobile.adapters.ShopAvatarAdapter;
import com.example.physxmobile.adapters.ShopTitleAdapter;
import com.example.physxmobile.helpers.SharedPreferenceHelper;
import com.example.physxmobile.models.ShopItem;
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
        TextView shopCoinsTextView = view.findViewById(R.id.shopCoinsTextView);
        TextView shopCurrentTitleTextView = view.findViewById(R.id.shopCurrentTitleTextView);
        ImageView shopCurrentAvatarImageView = view.findViewById(R.id.shopCurrentAvatarImageView);
        NestedScrollView shopNestedScrollView = view.findViewById(R.id.shopNestedScrollView);
        ProgressBar shopProgressBar = view.findViewById(R.id.shopProgressBar);

        shopViewModel.init(helper.getAccessToken());
        shopProgressBar.setVisibility(View.VISIBLE);
        shopNestedScrollView.setVisibility(View.GONE);

        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), new Observer<ShopItem>() {
            @Override
            public void onChanged(ShopItem shopItems) {
                shopCoinsTextView.setText(String.valueOf(shopItems.getCoins()));
                if (shopItems.getTitle() == null) {
                    shopCurrentTitleTextView.setText("Novice");
                } else {
                    shopCurrentTitleTextView.setText(shopItems.getTitle());
                }
                if (shopItems.getAvatar() == null) {
                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/avatar_1.png")
                            .into(shopCurrentAvatarImageView);
                } else {
                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/" + shopItems.getAvatar())
                            .into(shopCurrentAvatarImageView);
                }

                List<ShopItem.ShopItems> temp = new ArrayList<>();
                List<ShopItem.OwnedItems> ownedItems = new ArrayList<>();
                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                    if (shopItem.getType().equals("title")) {
                        temp.add(shopItem);
                    }
                }
                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                    if (ownedItem.getType().equals("title")) {
                        ownedItems.add(ownedItem);
                    }
                }

                ShopTitleAdapter shopTitleAdapter = new ShopTitleAdapter(temp, ownedItems, shopViewModel, shopItems.getCoins());
                shopTitleRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                shopTitleRecyclerView.setAdapter(shopTitleAdapter);

                temp = new ArrayList<>();
                ownedItems = new ArrayList<>();
                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                    if (shopItem.getType().equals("avatar")) {
                        temp.add(shopItem);
                    }
                }
                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                    if (ownedItem.getType().equals("avatar")) {
                        ownedItems.add(ownedItem);
                    }
                }
                ShopAvatarAdapter shopAvatarAdapter = new ShopAvatarAdapter(temp, ownedItems, shopViewModel, shopItems.getCoins());
                shopAvatarRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                shopAvatarRecyclerView.setAdapter(shopAvatarAdapter);

                shopTitleAdapter.setCallBack(new ShopTitleAdapter.CallBack() {
                    @Override
                    public void refresh() {
                        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), new Observer<ShopItem>() {
                            @Override
                            public void onChanged(ShopItem shopItems) {
                                shopCoinsTextView.setText(String.valueOf(shopItems.getCoins()));
                                if (shopItems.getTitle() == null) {
                                    shopCurrentTitleTextView.setText("Novice");
                                } else {
                                    shopCurrentTitleTextView.setText(shopItems.getTitle());
                                }
                                if (shopItems.getAvatar() == null) {
                                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/avatar_1.png")
                                            .into(shopCurrentAvatarImageView);
                                } else {
                                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/" + shopItems.getAvatar())
                                            .into(shopCurrentAvatarImageView);
                                }

                                List<ShopItem.ShopItems> temp = new ArrayList<>();
                                List<ShopItem.OwnedItems> ownedItems = new ArrayList<>();
                                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                                    if (shopItem.getType().equals("title")) {
                                        temp.add(shopItem);
                                    }
                                }
                                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                                    if (ownedItem.getType().equals("title")) {
                                        ownedItems.add(ownedItem);
                                    }
                                }

                                shopTitleAdapter.setShopItemList(temp);
                                shopTitleAdapter.setOwnedItemList(ownedItems);
                                shopTitleAdapter.setCoins(shopItems.getCoins());
                                shopTitleAdapter.notifyDataSetChanged();

                                temp = new ArrayList<>();
                                ownedItems = new ArrayList<>();
                                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                                    if (shopItem.getType().equals("avatar")) {
                                        temp.add(shopItem);
                                    }
                                }
                                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                                    if (ownedItem.getType().equals("avatar")) {
                                        ownedItems.add(ownedItem);
                                    }
                                }

                                shopAvatarAdapter.setShopItemList(temp);
                                shopAvatarAdapter.setOwnedItemList(ownedItems);
                                shopAvatarAdapter.setCoins(shopItems.getCoins());
                                shopAvatarAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });

                shopAvatarAdapter.setCallBack(new ShopAvatarAdapter.CallBack() {
                    @Override
                    public void refresh() {
                        shopViewModel.getShopItems().observe(getViewLifecycleOwner(), new Observer<ShopItem>() {
                            @Override
                            public void onChanged(ShopItem shopItems) {
                                shopCoinsTextView.setText(String.valueOf(shopItems.getCoins()));
                                if (shopItems.getTitle() == null) {
                                    shopCurrentTitleTextView.setText("Novice");
                                } else {
                                    shopCurrentTitleTextView.setText(shopItems.getTitle());
                                }
                                if (shopItems.getAvatar() == null) {
                                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/avatar_1.png")
                                            .into(shopCurrentAvatarImageView);
                                } else {
                                    Glide.with(getContext()).load("http://159.89.208.113/img/avatars/" + shopItems.getAvatar())
                                            .into(shopCurrentAvatarImageView);
                                }

                                List<ShopItem.ShopItems> temp = new ArrayList<>();
                                List<ShopItem.OwnedItems> ownedItems = new ArrayList<>();
                                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                                    if (shopItem.getType().equals("title")) {
                                        temp.add(shopItem);
                                    }
                                }
                                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                                    if (ownedItem.getType().equals("title")) {
                                        ownedItems.add(ownedItem);
                                    }
                                }

                                shopTitleAdapter.setShopItemList(temp);
                                shopTitleAdapter.setOwnedItemList(ownedItems);
                                shopTitleAdapter.setCoins(shopItems.getCoins());
                                shopTitleAdapter.notifyDataSetChanged();

                                temp = new ArrayList<>();
                                ownedItems = new ArrayList<>();
                                for (ShopItem.ShopItems shopItem : shopItems.getShop_items()) {
                                    if (shopItem.getType().equals("avatar")) {
                                        temp.add(shopItem);
                                    }
                                }
                                for (ShopItem.OwnedItems ownedItem : shopItems.getOwned_items()) {
                                    if (ownedItem.getType().equals("avatar")) {
                                        ownedItems.add(ownedItem);
                                    }
                                }

                                shopAvatarAdapter.setShopItemList(temp);
                                shopAvatarAdapter.setOwnedItemList(ownedItems);
                                shopAvatarAdapter.setCoins(shopItems.getCoins());
                                shopAvatarAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                });

                shopProgressBar.setVisibility(View.GONE);
                shopNestedScrollView.setVisibility(View.VISIBLE);
            }
        });
    }
}