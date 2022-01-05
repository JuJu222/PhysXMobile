package com.example.physxmobile.adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.ShopItem;
import com.example.physxmobile.viewmodels.ShopViewModel;

import java.util.List;

public class ShopTitleAdapter extends RecyclerView.Adapter<ShopTitleAdapter.ViewHolder> {
    private List<ShopItem.ShopItems> shopItemList;
    private List<ShopItem.OwnedItems> ownedItemList;
    private ShopViewModel shopViewModel;
    private int coins;
    private CallBack callBack;

    public ShopTitleAdapter(List<ShopItem.ShopItems> shopItemList, List<ShopItem.OwnedItems> ownedItemList, ShopViewModel shopViewModel, int coins) {
        this.shopItemList = shopItemList;
        this.ownedItemList = ownedItemList;
        this.shopViewModel = shopViewModel;
        this.coins = coins;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_shop_title, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowShopTitleItemTextView.setText(shopItemList.get(position).getItem());
        holder.rowShopTitlePriceTextView.setText(String.valueOf(shopItemList.get(position).getPrice()));
        if (coins >= shopItemList.get(position).getPrice()) {
            holder.rowShopTitleBuyButton.setEnabled(true);
            holder.rowShopTitleBuyButton.setAlpha(1);
        } else {
            holder.rowShopTitleBuyButton.setEnabled(false);
            holder.rowShopTitleBuyButton.setAlpha(0.5f);
        }

        for (ShopItem.OwnedItems ownedItem : ownedItemList) {
            if (shopItemList.get(position).getShop_item_id() == ownedItem.getShop_item_id()) {
                holder.rowShopTitleEquipButton.setVisibility(View.VISIBLE);
                holder.rowShopTitleBuyButton.setVisibility(View.GONE);

                if (ownedItem.getPivot().getIs_equipped() == 1) {
                    holder.rowShopTitleEquipButton.setEnabled(false);
                    holder.rowShopTitleEquipButton.setAlpha(0.5f);
                } else {
                    holder.rowShopTitleEquipButton.setEnabled(true);
                    holder.rowShopTitleEquipButton.setAlpha(1);
                }

                holder.rowShopTitleEquipButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        shopViewModel.equipShopItem(shopItemList.get(holder.getAdapterPosition()).getShop_item_id()).observe((LifecycleOwner) holder.rowShopTitleEquipButton.getContext(), new Observer<ShopItem.ShopItemEquipResponse>() {
                            @Override
                            public void onChanged(ShopItem.ShopItemEquipResponse shopItemEquipResponse) {
                                callBack.refresh();
                            }
                        });
                    }
                });
            }
        }

        holder.rowShopTitleBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopViewModel.buyShopItem(shopItemList.get(holder.getAdapterPosition()).getShop_item_id()).observe((LifecycleOwner) holder.rowShopTitleBuyButton.getContext(), new Observer<ShopItem.ShopItemBuyResponse>() {
                    @Override
                    public void onChanged(ShopItem.ShopItemBuyResponse shopItemBuyResponse) {
                        if (shopItemBuyResponse.getMessage().equals("Buy shop item successful")) {
                            callBack.refresh();
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
        TextView rowShopTitleItemTextView;
        TextView rowShopTitlePriceTextView;
        TextView rowShopTitleBuyButton;
        TextView rowShopTitleEquipButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowShopTitleItemTextView = itemView.findViewById(R.id.rowShopTitleItemTextView);
            rowShopTitlePriceTextView = itemView.findViewById(R.id.rowShopTitlePriceTextView);
            rowShopTitleBuyButton = itemView.findViewById(R.id.rowShopTitleBuyButton);
            rowShopTitleEquipButton = itemView.findViewById(R.id.rowShopTitleEquipButton);
        }
    }

    public void setShopItemList(List<ShopItem.ShopItems> shopItemList) {
        this.shopItemList = shopItemList;
    }

    public void setOwnedItemList(List<ShopItem.OwnedItems> ownedItemList) {
        this.ownedItemList = ownedItemList;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public interface CallBack{
        void refresh();
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}
