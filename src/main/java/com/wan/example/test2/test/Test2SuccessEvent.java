package com.wan.example.test2.test;

import org.springframework.context.ApplicationEvent;

public class Test2SuccessEvent extends ApplicationEvent {

    private String test;


    public Test2SuccessEvent(Object source, String test) {
        super(source);
        this.test = test;
    }

    public String getTest() {
        return test;
    }


}
