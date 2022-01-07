package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class LeaderboardModel {

    private List<Leaderboard> leaderboard;
    private String topic;

    public static LeaderboardModel objectFromData(String str) {

        return new Gson().fromJson(str, LeaderboardModel.class);
    }

    public List<Leaderboard> getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(List<Leaderboard> leaderboard) {
        this.leaderboard = leaderboard;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public static class Leaderboard {
        private int fis10_user_id;
        private String name;
        private int total_score;
        private String title;
        private String avatar;

        public static Leaderboard objectFromData(String str) {

            return new Gson().fromJson(str, Leaderboard.class);
        }

        public int getFis10_user_id() {
            return fis10_user_id;
        }

        public void setFis10_user_id(int fis10_user_id) {
            this.fis10_user_id = fis10_user_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTotal_score() {
            return total_score;
        }

        public void setTotal_score(int total_score) {
            this.total_score = total_score;
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
    }
}
