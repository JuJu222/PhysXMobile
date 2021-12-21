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
        private String image_path;
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

        public void setImage_path(String image_path) {
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

    public static class ShopItemBuyResponse {

        private String message;
        private Fis10user fis10user;

        public static ShopItemBuyResponse objectFromData(String str) {

            return new Gson().fromJson(str, ShopItemBuyResponse.class);
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Fis10user getFis10user() {
            return fis10user;
        }

        public void setFis10user(Fis10user fis10user) {
            this.fis10user = fis10user;
        }

        public static class Fis10user {
            private int fis10_user_id;
            private int user_id;
            private int coins;
            private String title;
            private String avatar;
            private String created_at;
            private String updated_at;

            public static Fis10user objectFromData(String str) {

                return new Gson().fromJson(str, Fis10user.class);
            }

            public int getFis10_user_id() {
                return fis10_user_id;
            }

            public void setFis10_user_id(int fis10_user_id) {
                this.fis10_user_id = fis10_user_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getCoins() {
                return coins;
            }

            public void setCoins(int coins) {
                this.coins = coins;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
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
}
