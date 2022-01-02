package com.example.physxmobile.models;

import com.google.gson.Gson;

public class UserModel {

    private User user;
    private Fis10user fis10user;




    public static UserModel objectFromData(String str) {

        return new Gson().fromJson(str, UserModel.class);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fis10user getFis10user() {
        return fis10user;
    }

    public void setFis10user(Fis10user fis10user) {
        this.fis10user = fis10user;
    }

    public static class User {
        private int id;
        private String name;
        private String email;
        private Object email_verified_at;
        private String is_login;
        private String is_active;
        private String username;
        private String school;
        private String city;
        private int birthyear;
        private String role;
        private String created_at;
        private String updated_at;

        public User(String name, String username, String email, int birthyear, String city, String school) {
            this.name = name;
            this.username = username;
            this.email = email;
            this.birthyear = birthyear;
            this.city = city;
            this.school = school;
        }

        public static User objectFromData(String str) {

            return new Gson().fromJson(str, User.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmail_verified_at() {
            return email_verified_at;
        }

        public void setEmail_verified_at(Object email_verified_at) {
            this.email_verified_at = email_verified_at;
        }

        public String getIs_login() {
            return is_login;
        }

        public void setIs_login(String is_login) {
            this.is_login = is_login;
        }

        public String getIs_active() {
            return is_active;
        }

        public void setIs_active(String is_active) {
            this.is_active = is_active;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getBirthyear() {
            return birthyear;
        }

        public void setBirthyear(int birthyear) {
            this.birthyear = birthyear;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
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
