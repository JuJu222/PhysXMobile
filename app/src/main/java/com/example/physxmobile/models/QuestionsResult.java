package com.example.physxmobile.models;

import com.google.gson.Gson;

public class QuestionsResult {

    private int accuracy;
    private int total_score;
    private int total_questions;
    private int total_correct;
    private int total_minutes;
    private int total_seconds;

    public static QuestionsResult objectFromData(String str) {

        return new Gson().fromJson(str, QuestionsResult.class);
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getTotal_score() {
        return total_score;
    }

    public void setTotal_score(int total_score) {
        this.total_score = total_score;
    }

    public int getTotal_questions() {
        return total_questions;
    }

    public void setTotal_questions(int total_questions) {
        this.total_questions = total_questions;
    }

    public int getTotal_correct() {
        return total_correct;
    }

    public void setTotal_correct(int total_correct) {
        this.total_correct = total_correct;
    }

    public int getTotal_minutes() {
        return total_minutes;
    }

    public void setTotal_minutes(int total_minutes) {
        this.total_minutes = total_minutes;
    }

    public int getTotal_seconds() {
        return total_seconds;
    }

    public void setTotal_seconds(int total_seconds) {
        this.total_seconds = total_seconds;
    }
}
