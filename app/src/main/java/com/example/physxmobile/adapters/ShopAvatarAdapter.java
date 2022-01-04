package com.example.physxmobile.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.physxmobile.R;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.ShopViewModel;

import java.util.List;

public class ShopAvatarAdapter extends RecyclerView.Adapter<ShopAvatarAdapter.ViewHolder> {
    private List<ShopItem.ShopItems> shopItemList;
    private List<ShopItem.OwnedItems> ownedItemList;
    private ShopViewModel shopViewModel;

    public ShopAvatarAdapter(List<ShopItem.ShopItems> shopItemList, List<ShopItem.OwnedItems> ownedItemList, ShopViewModel shopViewModel) {
        this.shopItemList = shopItemList;
        this.ownedItemList = ownedItemList;
        this.shopViewModel = shopViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shop_avatar, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowShopAvatarItemTextView.setText(shopItemList.get(position).getItem());
        holder.rowShopAvatarPriceTextView.setText(String.valueOf(shopItemList.get(position).getPrice()));
        Glide.with(holder.rowShopAvatarImageView.getContext()).load(shopItemList.get(position).getImage_path())
                .into(holder.rowShopAvatarImageView);
        for (ShopItem.OwnedItems ownedItem : ownedItemList) {
            if (shopItemList.get(position).getShop_item_id() == ownedItem.getShop_item_id()) {
                holder.rowShopAvatarEquipButton.setVisibility(View.VISIBLE);
                holder.rowShopAvatarBuyButton.setVisibility(View.GONE);

                if (ownedItem.getPivot().getIs_equipped() == 1) {
                    holder.rowShopAvatarEquipButton.setEnabled(false);
                    holder.rowShopAvatarEquipButton.setAlpha(0.5f);
                } else {
                    holder.rowShopAvatarEquipButton.setEnabled(true);
                    holder.rowShopAvatarEquipButton.setAlpha(1);
                }

                holder.rowShopAvatarEquipButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shopViewModel.equipShopItem(shopItemList.get(holder.getAdapterPosition()).getShop_item_id()).observe((LifecycleOwner) holder.rowShopAvatarEquipButton.getContext(), new Observer<ShopItem.ShopItemEquipResponse>() {
                            @Override
                            public void onChanged(ShopItem.ShopItemEquipResponse shopItemEquipResponse) {
                                shopViewModel.getShopItems().observe((LifecycleOwner) holder.rowShopAvatarEquipButton.getContext(), new Observer<ShopItem>() {
                                    @Override
                                    public void onChanged(ShopItem shopItem) {
                                        ownedItemList = shopItem.getOwned_items();
                                        notifyDataSetChanged();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }

        holder.rowShopAvatarBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopViewModel.buyShopItem(shopItemList.get(holder.getAdapterPosition()).getShop_item_id()).observe((LifecycleOwner) holder.rowShopAvatarBuyButton.getContext(), new Observer<ShopItem.ShopItemBuyResponse>() {
                    @Override
                    public void onChanged(ShopItem.ShopItemBuyResponse shopItemBuyResponse) {
                        if (shopItemBuyResponse.getMessage().equals("Buy shop item successful")) {
                            shopViewModel.getShopItems().observe((LifecycleOwner) holder.rowShopAvatarEquipButton.getContext(), new Observer<ShopItem>() {
                                @Override
                                public void onChanged(ShopItem shopItem) {
                                    ownedItemList = shopItem.getOwned_items();
                                    notifyDataSetChanged();
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rowShopAvatarItemTextView;
        TextView rowShopAvatarPriceTextView;
        TextView rowShopAvatarBuyButton;
        TextView rowShopAvatarEquipButton;
        ImageView rowShopAvatarImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowShopAvatarItemTextView = itemView.findViewById(R.id.rowShopAvatarItemTextView);
            rowShopAvatarPriceTextView = itemView.findViewById(R.id.rowShopAvatarPriceTextView);
            rowShopAvatarBuyButton = itemView.findViewById(R.id.rowShopAvatarBuyButton);
            rowShopAvatarEquipButton = itemView.findViewById(R.id.rowShopAvatarEquipButton);
            rowShopAvatarImageView = itemView.findViewById(R.id.rowShopAvatarImageView);
        }
    }
}
