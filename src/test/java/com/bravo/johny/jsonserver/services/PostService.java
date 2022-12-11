package com.bravo.johny.jsonserver.services;

import com.bravo.johny.jsonserver.builders.CommentRequestBuilder;
import com.bravo.johny.jsonserver.clients.CommentClient;
import com.bravo.johny.jsonserver.clients.PostClient;
import com.bravo.johny.jsonserver.dtos.common.Post;
import com.bravo.johny.jsonserver.dtos.request.CommentRequest;
import com.bravo.johny.jsonserver.dtos.response.CommentResponse;
import com.bravo.johny.jsonserver.dtos.response.PostResponse;

import java.util.List;

public class PostService extends BaseService{

    private final PostClient client;
    private int statusCode;
    private String responseBodyString;

    public PostService() {
        this.client = new PostClient();
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

    public List<Post> getAllPosts() {

        var responseBody = client.getAllPosts();
        setStatusAndBody(client.getStatusCode(), client.getResponseBodyAsString());

        return responseBody;
    }
}
