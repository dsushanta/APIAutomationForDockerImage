package com.bravo.johny.jsonserver.hooks;


import com.bravo.johny.jsonserver.services.CommentService;
import io.cucumber.java.BeforeStep;

public class JsonServerHooks extends BaseHooks {

    CommentService commentService;

    @BeforeStep()
    public void print() {
        System.out.println("Printing before step");
    }
}
