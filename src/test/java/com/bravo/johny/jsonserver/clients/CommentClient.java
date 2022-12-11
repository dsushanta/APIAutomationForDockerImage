package com.bravo.johny.jsonserver.clients;

import com.bravo.johny.jsonserver.core.GenericRestHandler;
import com.bravo.johny.jsonserver.dtos.common.Comment;
import com.bravo.johny.jsonserver.dtos.request.CommentRequest;
import com.bravo.johny.jsonserver.dtos.response.CommentResponse;
import com.bravo.johny.jsonserver.config.Enums;
import com.bravo.johny.jsonserver.dtos.response.PostResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.List;

public class CommentClient extends BaseClient{

    private ResponseOptions<Response> response;

    public CommentClient(String token) {
        super(token);
    }

    public CommentClient() {
        super();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBodyAsString() {
        return response.getBody().asString();
    }

    public Comment addComment(CommentRequest payload) {
        String url = Enums.API_URLS.COMMENT.getValue();
        response = GenericRestHandler
                .getInstance()
                .addBody(payload)
                .ExecuteAPI(url, Enums.HTTP_METHOD.POST);

        return response.getBody().as(Comment.class);
    }

    public List<Comment> getAllComments() {
        String url = Enums.API_URLS.COMMENT.getValue();
        response = GenericRestHandler
                .getInstance()
                .ExecuteAPI(url, Enums.HTTP_METHOD.GET);

        return response.getBody().jsonPath().getList("$", Comment.class);
    }

    /*public UserLoginResponse login(UserLoginRequest payload) {
        String url = Enums.API_URLS.LOGIN.getValue();
        response = GenericRestHandler
                .getInstance()
                .addBody(payload)
                .ExecuteAPI(url, Enums.HTTP_METHOD.POST);

        return response.getBody().as(UserLoginResponse.class);
    }

    public UsersResponse getAllUsers() {
        String url = Enums.API_URLS.USERS.getValue();
        response = GenericRestHandler
                .getInstance()
                .addHeader("Authorization", "Bearer "+token)
                .ExecuteAPI(url, Enums.HTTP_METHOD.GET);

        return response.getBody().as(UsersResponse.class);
    }

    public UserRegistrationResponse registration(UserRegistrationRequest payload) {
        String url = Enums.API_URLS.REGISTRATION.getValue();
        response = GenericRestHandler
                .getInstance()
                .addBody(payload)
                .ExecuteAPI(url, Enums.HTTP_METHOD.POST);

        return response.getBody().as(UserRegistrationResponse.class);
    }*/
}
