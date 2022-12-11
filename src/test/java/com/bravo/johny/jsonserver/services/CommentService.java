package com.bravo.johny.jsonserver.services;

import com.bravo.johny.jsonserver.builders.CommentRequestBuilder;
import com.bravo.johny.jsonserver.clients.CommentClient;
import com.bravo.johny.jsonserver.dtos.common.Comment;
import com.bravo.johny.jsonserver.dtos.request.CommentRequest;
import com.bravo.johny.jsonserver.dtos.response.CommentResponse;

import java.util.List;

public class CommentService extends BaseService{

    private final CommentClient client;
    private int statusCode;
    private String responseBodyString;

    public CommentService(String token) {
        this.client = new CommentClient(token);
    }

    public CommentService() {
        this.client = new CommentClient();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBodyString() {
        return responseBodyString;
    }

    private void setStatusAndBody(int statusCode, String responseBodyString) {
        this.statusCode = statusCode;
        this.responseBodyString = responseBodyString;
    }

    public Comment addComment(int id, int postID, String body) {
        CommentRequest payload = new CommentRequestBuilder()
                .withId(id)
                .withBody(body)
                .withPostId(postID)
                .build();

        var responseBody = client.addComment(payload);
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }

    public List<Comment> getAllComments() {

        var responseBody = client.getAllComments();
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }

    /*public UserRegistrationResponse registration(String name, String email, String pwd) {
        UserRegistrationRequest payload = new UserRegistrationRequestBuilder()
                .withName(name)
                .withEmail(email)
                .withPassword(pwd)
                .build();

        var responseBody = client.registration(payload);
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }

    public UserLoginResponse login(String email, String pwd) {
        UserLoginRequest payload = new UserLoginRequestBuilder()
                .withEmail(email)
                .withPassword(pwd)
                .build();

        var responseBody = client.login(payload);
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }

    public UsersResponse getAllUsers() {
        var responseBody = client.getAllUsers();
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }*/
}
