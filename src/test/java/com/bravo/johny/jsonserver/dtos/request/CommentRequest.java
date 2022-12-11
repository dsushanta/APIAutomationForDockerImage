package com.bravo.johny.jsonserver.dtos.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@lombok.Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest extends BaseRequest{
    private Integer id;
    private String body;
    private Integer postId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}