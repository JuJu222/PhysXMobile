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

public class ShopTitleAdapter extends RecyclerView.Adapter<ShopTitleAdapter.ViewHolder> {
    private List<ShopItems.ShopItem> shopItemList;

    public ShopTitleAdapter(List<ShopItems.ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
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
        holder.rowShopTitleBuyButton.setOnClickListener(new View.OnClickListener() {
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
        TextView rowShopTitleItemTextView;
        TextView rowShopTitlePriceTextView;
        TextView rowShopTitleBuyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowShopTitleItemTextView = itemView.findViewById(R.id.rowShopTitleItemTextView);
            rowShopTitlePriceTextView = itemView.findViewById(R.id.rowShopTitlePriceTextView);
            rowShopTitleBuyButton = itemView.findViewById(R.id.rowShopTitleBuyButton);
        }
    }
}
