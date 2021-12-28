package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class HomeResponse {

    private String name;
    private List<UnlockedTopics> unlocked_topics;
    private int total_score;
    private int ranking;

    public static HomeResponse objectFromData(String str) {

        return new Gson().fromJson(str, HomeResponse.class);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnlockedTopics> getUnlocked_topics() {
        return unlocked_topics;
    }

    public void setUnlocked_topics(List<UnlockedTopics> unlocked_topics) {
        this.unlocked_topics = unlocked_topics;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public static class UnlockedTopics {
        private int topic_id;
        private String topic_name;
        private String description;
        private String topic_image;
        private String difficulty;
        private String created_at;
        private String updated_at;
        private Pivot pivot;

        public static UnlockedTopics objectFromData(String str) {

            return new Gson().fromJson(str, UnlockedTopics.class);
        }

        public int getTopic_id() {
            return topic_id;
        }

        public void setTopic_id(int topic_id) {
            this.topic_id = topic_id;
        }

        public String getTopic_name() {
            return topic_name;
        }

        public void setTopic_name(String topic_name) {
            this.topic_name = topic_name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTopic_image() {
            return topic_image;
        }

        public void setTopic_image(String topic_image) {
            this.topic_image = topic_image;
        }

        public String getDifficulty() {
            return difficulty;
        }

        public void setDifficulty(String difficulty) {
            this.difficulty = difficulty;
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
            private int topic_id;

            public static Pivot objectFromData(String str) {

                return new Gson().fromJson(str, Pivot.class);
            }

            public int getFis10_user_id() {
                return fis10_user_id;
            }

            public void setFis10_user_id(int fis10_user_id) {
                this.fis10_user_id = fis10_user_id;
            }

            public int getTopic_id() {
                return topic_id;
            }

            public void setTopic_id(int topic_id) {
                this.topic_id = topic_id;
            }
        }
    }
}
