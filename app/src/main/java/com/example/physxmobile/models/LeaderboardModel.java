package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class LeaderboardModel {

    private List<Leaderboard> leaderboard;

    public static Leaderboard objectFromData(String str) {

        return new Gson().fromJson(str, Leaderboard.class);
    }

    public List<Leaderboard> getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(List<Leaderboard> leaderboard) {
        this.leaderboard = leaderboard;
    }

    public static class Leaderboard {
        private String name;
        private int total_score;

        public static Leaderboard objectFromData(String str) {

            return new Gson().fromJson(str, Leaderboard.class);
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
    }
}
