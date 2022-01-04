package com.example.physxmobile.models;

import com.google.gson.Gson;

public class TopicModel {
    private Topic topic;

    public static Topic objectFromData(String str) {

        return new Gson().fromJson(str, Topic.class);
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public static class Topic {
        private int topic_id;
        private String topic_name;
        private String description;
        private String topic_image;
        private String difficulty;
        private String created_at;
        private String updated_at;

        public static Topic objectFromData(String str) {

            return new Gson().fromJson(str, Topic.class);
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
    }
}
