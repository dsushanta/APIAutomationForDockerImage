package com.bravo.johny.jsonserver.tests;

import com.bravo.johny.jsonserver.services.CommentService;
import com.bravo.johny.jsonserver.services.PostService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsonServerTests {
    protected PostService postService = new PostService();
    protected CommentService commentService = new CommentService();

    @Test
    public void TestAddCommentFeature(){
        var comment = "Hello World";
        var posts = postService.getAllPosts();
        var postId = posts.get(0).getId();
        var comments = commentService.getAllComments();
        var commentId = comments.size() + 1;
        commentService.addComment(commentId, postId, comment);

        var count = commentService.getAllComments().size();

        Assert.assertEquals(count, commentId);
    }
}
