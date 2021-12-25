package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class ShopItem {


    private List<ShopItems> shop_items;
    private List<OwnedItems> owned_items;

    public static ShopItems objectFromData(String str) {

        return new Gson().fromJson(str, ShopItems.class);
    }

    public List<ShopItems> getShop_items() {
        return shop_items;
    }

    public void setShop_items(List<ShopItems> shop_items) {
        this.shop_items = shop_items;
    }

    public List<OwnedItems> getOwned_items() {
        return owned_items;
    }

    public void setOwned_items(List<OwnedItems> owned_items) {
        this.owned_items = owned_items;
    }

    public static class ShopItemBuyResponse {

        private String message;
        private List<OwnedItem> ownedItem;

        public static ShopItemBuyResponse objectFromData(String str) {

            return new Gson().fromJson(str, ShopItemBuyResponse.class);
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<OwnedItem> getOwnedItem() {
            return ownedItem;
        }

        public void setOwnedItem(List<OwnedItem> ownedItem) {
            this.ownedItem = ownedItem;
        }

        public static class OwnedItem {
            private int fis10_user_id;
            private int user_id;
            private int coins;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static OwnedItem objectFromData(String str) {

                return new Gson().fromJson(str, OwnedItem.class);
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

            public Pivot getPivot() {
                return pivot;
            }

            public void setPivot(Pivot pivot) {
                this.pivot = pivot;
            }

            public static class Pivot {
                private int shop_item_id;
                private int fis10_user_id;
                private int is_equipped;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getShop_item_id() {
                    return shop_item_id;
                }

                public void setShop_item_id(int shop_item_id) {
                    this.shop_item_id = shop_item_id;
                }

                public int getFis10_user_id() {
                    return fis10_user_id;
                }

                public void setFis10_user_id(int fis10_user_id) {
                    this.fis10_user_id = fis10_user_id;
                }

                public int getIs_equipped() {
                    return is_equipped;
                }

                public void setIs_equipped(int is_equipped) {
                    this.is_equipped = is_equipped;
                }
            }
        }
    }

    public static class ShopItemEquipResponse {

        private String message;
        private List<OwnedItem> ownedItem;

        public static ShopItemEquipResponse objectFromData(String str) {

            return new Gson().fromJson(str, ShopItemEquipResponse.class);
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<OwnedItem> getOwnedItem() {
            return ownedItem;
        }

        public void setOwnedItem(List<OwnedItem> ownedItem) {
            this.ownedItem = ownedItem;
        }

        public static class OwnedItem {
            private int fis10_user_id;
            private int user_id;
            private int coins;
            private String created_at;
            private String updated_at;
            private Pivot pivot;

            public static OwnedItem objectFromData(String str) {

                return new Gson().fromJson(str, OwnedItem.class);
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

            public Pivot getPivot() {
                return pivot;
            }

            public void setPivot(Pivot pivot) {
                this.pivot = pivot;
            }

            public static class Pivot {
                private int shop_item_id;
                private int fis10_user_id;
                private int is_equipped;

                public static Pivot objectFromData(String str) {

                    return new Gson().fromJson(str, Pivot.class);
                }

                public int getShop_item_id() {
                    return shop_item_id;
                }

                public void setShop_item_id(int shop_item_id) {
                    this.shop_item_id = shop_item_id;
                }

                public int getFis10_user_id() {
                    return fis10_user_id;
                }

                public void setFis10_user_id(int fis10_user_id) {
                    this.fis10_user_id = fis10_user_id;
                }

                public int getIs_equipped() {
                    return is_equipped;
                }

                public void setIs_equipped(int is_equipped) {
                    this.is_equipped = is_equipped;
                }
            }
        }
    }

    public static class ShopItems {
        private int shop_item_id;
        private String item;
        private String type;
        private Object image_path;
        private int price;
        private String created_at;
        private String updated_at;

        public static ShopItems objectFromData(String str) {

            return new Gson().fromJson(str, ShopItems.class);
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

    public static class OwnedItems {
        private int shop_item_id;
        private String item;
        private String type;
        private Object image_path;
        private int price;
        private String created_at;
        private String updated_at;
        private Pivot pivot;

        public static OwnedItems objectFromData(String str) {

            return new Gson().fromJson(str, OwnedItems.class);
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

        public Pivot getPivot() {
            return pivot;
        }

        public void setPivot(Pivot pivot) {
            this.pivot = pivot;
        }

        public static class Pivot {
            private int fis10_user_id;
            private int shop_item_id;
            private int is_equipped;

            public static Pivot objectFromData(String str) {

                return new Gson().fromJson(str, Pivot.class);
            }

            public int getFis10_user_id() {
                return fis10_user_id;
            }

            public void setFis10_user_id(int fis10_user_id) {
                this.fis10_user_id = fis10_user_id;
            }

            public int getShop_item_id() {
                return shop_item_id;
            }

            public void setShop_item_id(int shop_item_id) {
                this.shop_item_id = shop_item_id;
            }

            public int getIs_equipped() {
                return is_equipped;
            }

            public void setIs_equipped(int is_equipped) {
                this.is_equipped = is_equipped;
            }
        }
    }
}
