package com.wan.example.test;


import lombok.ToString;

import java.lang.reflect.Field;

@ToString
public class TestSuccessEvent {

    private String test;
    private User user;

    public TestSuccessEvent(String test, User user) {
        this.test = test;
        this.user = user;
    }

    public String getTest() {
        return test;
    }

    public User getUser() {
        return user;
    }
}
