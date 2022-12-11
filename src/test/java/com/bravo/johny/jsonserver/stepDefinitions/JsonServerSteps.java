package com.bravo.johny.jsonserver.stepDefinitions;


/*public class JsonServerSteps extends BaseSteps{

    CommentResponse commentResponse;

    public JsonServerSteps(ScenarioContext scenarioContext) {
        super(scenarioContext);
        //commentService = new CommentService(scenarioContext.getContext("token").toString());
        commentService = new CommentService();
        postService = new PostService();
    }

    @When("I make a POST call to add a comment")
    public void iMakeAPOSTCallToAddAComment(DataTable dataTable) {
        var comment = dataTable.asList(CommentEntity.class).get(0);
        var posts = postService.getAllPosts();
        var postId = posts.get(0).getId();

        var comments = commentService.getAllComments();
        var commentId = comments.size() + 1;

        commentService.addComment(commentId, postId, comment.getComment());
    }

    @Then("I get response status code as {int}")
    public void iGetResponseStatusCodeAs(int arg0) {
    }

    @Then("New post with comment {string} is present in the list of all posts")
    public void newPostWithCommentIsPresentInTheListOfAllPosts(String arg0) {
    }
}*/
