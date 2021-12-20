package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class ShopItems {

    private List<ShopItem> shop_items;

    public static ShopItems objectFromData(String str) {

        return new Gson().fromJson(str, ShopItems.class);
    }

    public List<ShopItem> getShop_items() {
        return shop_items;
    }

    public void setShop_items(List<ShopItem> shop_items) {
        this.shop_items = shop_items;
    }

    public static class ShopItem {
        private int shop_item_id;
        private String item;
        private String type;
        private Object image_path;
        private int price;
        private String created_at;
        private String updated_at;

        public static ShopItem objectFromData(String str) {

            return new Gson().fromJson(str, ShopItem.class);
        }

        public int getShop_item_id() {
            return shop_item_id;
        }

        public void setShop_item_id(int shop_item_id) {
            this.shop_item_id = shop_item_id;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getImage_path() {
            return image_path;
        }

        public void setImage_path(Object image_path) {
            this.image_path = image_path;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
