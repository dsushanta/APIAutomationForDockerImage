package com.bravo.johny.jsonserver.builders;

import com.bravo.johny.jsonserver.builders.common.RequestBuilder;
import com.bravo.johny.jsonserver.dtos.request.CommentRequest;

public class CommentRequestBuilder extends RequestBuilder<CommentRequest> {

    public CommentRequestBuilder() {
        request = new CommentRequest();
    }

    public CommentRequestBuilder withId(int id) {
        request.setId(id);
        return this;
    }

    public CommentRequestBuilder withPostId(int postId) {
        request.setPostId(postId);
        return this;
    }

    public CommentRequestBuilder withBody(String body) {
        request.setBody(body);
        return this;
    }
}