package com.bravo.johny.jsonserver.config;

public class Enums {

    public enum API_URLS {

        /*REGISTRATION("/api/authaccount/registration"),
        LOGIN("/api/authaccount/login"),
        USERS("/api/users"),
        USERDETAILS("/api/users/{id}");*/

        COMMENT("/comments"),
        POST("/posts");

        private final String value;

        API_URLS(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum HTTP_METHOD {
        GET,
        POST,
        PUT,
        DELETE
    }
}
