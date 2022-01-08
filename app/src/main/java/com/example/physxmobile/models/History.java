package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class History {

    private List<Histories> histories;

    public static History objectFromData(String str) {

        return new Gson().fromJson(str, History.class);
    }

    public List<Histories> getHistories() {
        return histories;
    }

    public void setHistories(List<Histories> histories) {
        this.histories = histories;
    }

    public static class Histories {
        private String topic_name;
        private int total_score;
        private String difficulty;

        public static Histories objectFromData(String str) {

            return new Gson().fromJson(str, Histories.class);
        }

        public String getTopic_name() {
            return topic_name;
        }

        public void setTopic_name(String topic_name) {
            this.topic_name = topic_name;
        }

        public int getTotal_score() {
            return total_score;
        }

        public void setTotal_score(int total_score) {
            this.total_score = total_score;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
        }
    }
}
