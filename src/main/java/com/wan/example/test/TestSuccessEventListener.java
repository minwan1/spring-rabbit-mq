package com.wan.example.test;

import com.wan.example.user.UserRegistrationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class TestSuccessEventListener {

    @Async("threadPoolTaskExecutor")
    @TransactionalEventListener
    void handleRegistration(TestSuccessEvent event){
        System.out.println("Registration event got triggered for customer::  " + event.getTest());
        //mail

        if(true){
            throw new RuntimeException();
        }
        try {
            Thread.sleep(5000L);
            System.out.println("test event");

        } catch (InterruptedException e) {
        }
    }

}
