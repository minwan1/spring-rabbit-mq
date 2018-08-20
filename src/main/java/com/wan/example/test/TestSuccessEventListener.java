package com.wan.example.test;

import com.wan.example.user.UserRegistrationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TestSuccessEventListener {

    @TransactionalEventListener
    void handleRegistration(TestSuccessEvent event){
        System.out.println("Registration event got triggered for customer::  " + event.getTest());
        //mail

        if(true){
            throw new RuntimeException();
        }
        try {
            Thread.sleep(3000L);
            System.out.println("zxcvxzxcz");

        } catch (InterruptedException e) {
        }
    }

}
