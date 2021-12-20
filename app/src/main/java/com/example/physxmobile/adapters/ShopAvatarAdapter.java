package com.example.physxmobile.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physxmobile.R;
import com.example.physxmobile.models.ShopItems;

import java.util.List;

public class ShopAvatarAdapter extends RecyclerView.Adapter<ShopAvatarAdapter.ViewHolder> {
    private List<ShopItems.ShopItem> shopItemList;

    public ShopAvatarAdapter(List<ShopItems.ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
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
        holder.rowShopAvatarBuyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowShopAvatarItemTextView = itemView.findViewById(R.id.rowShopAvatarItemTextView);
            rowShopAvatarPriceTextView = itemView.findViewById(R.id.rowShopAvatarPriceTextView);
            rowShopAvatarBuyButton = itemView.findViewById(R.id.rowShopAvatarBuyButton);
        }
    }
}
