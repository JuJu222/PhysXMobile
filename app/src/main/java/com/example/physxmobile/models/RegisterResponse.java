package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class RegisterResponse {

    private String message;
    private Errors errors;

    public static RegisterResponse objectFromData(String str) {

        return new Gson().fromJson(str, RegisterResponse.class);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public static class Errors {
        private List<String> name;
        private List<String> email;
        private List<String> password;
        private List<String> username;
        private List<String> school;
        private List<String> city;
        private List<String> birthyear;

        public static Errors objectFromData(String str) {

            return new Gson().fromJson(str, Errors.class);
        }

        public List<String> getName() {
            return name;
        }

        public void setName(List<String> name) {
            this.name = name;
        }

        public List<String> getEmail() {
            return email;
        }

        public void setEmail(List<String> email) {
            this.email = email;
        }

        public List<String> getPassword() {
            return password;
        }

        public void setPassword(List<String> password) {
            this.password = password;
        }

        public List<String> getUsername() {
            return username;
        }

        public void setUsername(List<String> username) {
            this.username = username;
        }

        public List<String> getSchool() {
            return school;
        }

        public void setSchool(List<String> school) {
            this.school = school;
        }

        public List<String> getCity() {
            return city;
        }

        public void setCity(List<String> city) {
            this.city = city;
        }

        public List<String> getBirthyear() {
            return birthyear;
        }

        public void setBirthyear(List<String> birthyear) {
            this.birthyear = birthyear;
        }
    }
}
