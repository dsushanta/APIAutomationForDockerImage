package com.bravo.johny.jsonserver.clients;

public class BaseClient implements IClient{
    protected String token;

    public BaseClient() {
    }

    public BaseClient(String token) {
        this.token = token;
    }
}
