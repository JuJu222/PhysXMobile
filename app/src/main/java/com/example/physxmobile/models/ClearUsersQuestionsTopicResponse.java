package com.example.physxmobile.models;

import com.google.gson.Gson;

public class ClearUsersQuestionsTopicResponse {

    private String message;

    public static ClearUsersQuestionsTopicResponse objectFromData(String str) {

        return new Gson().fromJson(str, ClearUsersQuestionsTopicResponse.class);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
