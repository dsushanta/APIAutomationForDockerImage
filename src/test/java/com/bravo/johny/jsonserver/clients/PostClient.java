package com.bravo.johny.jsonserver.clients;

import com.bravo.johny.jsonserver.config.Enums;
import com.bravo.johny.jsonserver.core.GenericRestHandler;
import com.bravo.johny.jsonserver.dtos.common.Post;
import com.bravo.johny.jsonserver.dtos.request.CommentRequest;
import com.bravo.johny.jsonserver.dtos.response.CommentResponse;
import com.bravo.johny.jsonserver.dtos.response.PostResponse;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.List;

public class PostClient extends BaseClient{

    private ResponseOptions<Response> response;

    public PostClient(String token) {
        super(token);
    }

    public PostClient() {
        super();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBodyAsString() {
        return response.getBody().asString();
    }

    public List<Post> getAllPosts() {
        String url = Enums.API_URLS.POST.getValue();
        response = GenericRestHandler
                .getInstance()
                .ExecuteAPI(url, Enums.HTTP_METHOD.GET);
        return response.getBody().jsonPath().getList("$",Post.class);
    }
}
