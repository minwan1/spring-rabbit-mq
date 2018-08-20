package com.wan.example.user;

public class UserRegistrationEvent {

    private String name;

    public UserRegistrationEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}