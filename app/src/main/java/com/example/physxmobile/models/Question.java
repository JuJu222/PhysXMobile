package com.example.physxmobile.models;

import com.google.gson.Gson;

import java.util.List;

public class Question {

    private List<Questions> questions;

    public static Question objectFromData(String str) {

        return new Gson().fromJson(str, Question.class);
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public static class Questions {
        private int question_id;
        private String question_type;
        private String question;
        private String image_path;
        private int topic_id;
        private String created_at;
        private String updated_at;
        private List<Options> options;

        public static Questions objectFromData(String str) {

            return new Gson().fromJson(str, Questions.class);
        }

        public int getQuestion_id() {
            return question_id;
        }

        public void setQuestion_id(int question_id) {
            this.question_id = question_id;
        }

        public String getQuestion_type() {
            return question_type;
        }

        public void setQuestion_type(String question_type) {
            this.question_type = question_type;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public int getTopic_id() {
            return topic_id;
        }

        public void setTopic_id(int topic_id) {
            this.topic_id = topic_id;
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

        public List<Options> getOptions() {
            return options;
        }

        public void setOptions(List<Options> options) {
            this.options = options;
        }

        public static class Options {
            private int option_mcq_id;
            private String option;
            private int is_correct;
            private int question_id;
            private int option_tof_id;
            private boolean true_or_false;
            private int option_fitb_id;
            private String answer;

            public int getOption_tof_id() {
                return option_tof_id;
            }

            public void setOption_tof_id(int option_tof_id) {
                this.option_tof_id = option_tof_id;
            }

            public boolean isTrue_or_false() {
                return true_or_false;
            }

            public void setTrue_or_false(boolean true_or_false) {
                this.true_or_false = true_or_false;
            }

            public int getOption_fitb_id() {
                return option_fitb_id;
            }

            public void setOption_fitb_id(int option_fitb_id) {
                this.option_fitb_id = option_fitb_id;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public static Options objectFromData(String str) {

                return new Gson().fromJson(str, Options.class);
            }

            public int getOption_mcq_id() {
                return option_mcq_id;
            }

            public void setOption_mcq_id(int option_mcq_id) {
                this.option_mcq_id = option_mcq_id;
            }

            public String getOption() {
                return option;
            }

            public void setOption(String option) {
                this.option = option;
            }

            public int getIs_correct() {
                return is_correct;
            }

            public void setIs_correct(int is_correct) {
                this.is_correct = is_correct;
            }

            public int getQuestion_id() {
                return question_id;
            }

            public void setQuestion_id(int question_id) {
                this.question_id = question_id;
            }
        }
    }
}
