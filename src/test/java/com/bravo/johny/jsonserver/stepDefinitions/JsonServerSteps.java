package com.bravo.johny.jsonserver.stepDefinitions;

import com.bravo.johny.jsonserver.core.ScenarioContext;
import com.bravo.johny.jsonserver.dtos.response.CommentResponse;
import com.bravo.johny.jsonserver.services.CommentService;
import com.bravo.johny.jsonserver.services.PostService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class JsonServerSteps extends BaseSteps {
    CommentResponse commentResponse;

    public JsonServerSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        commentService = new CommentService();
        postService = new PostService();
    }

    @When("I make a POST call to add a comment {string}")
    public void iMakeAPOSTCallToAddAComment(String comment) {
        var posts = postService.getAllPosts();
        var postId = posts.get(0).getId();
        var commentId = commentService.getAllComments().size() + 1;
        commentService.addComment(commentId, postId, comment);
    }

    @Then("I get response status code as {int}")
    public void iGetResponseStatusCodeAs(int arg0) {
    }

    @And("New post with comment {string} is present in the list of all posts")
    public void newPostWithCommentIsPresentInTheListOfAllPosts(String arg0) {
    }
}
