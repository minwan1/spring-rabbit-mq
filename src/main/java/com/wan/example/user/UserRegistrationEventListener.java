package com.wan.example.user;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserRegistrationEventListener {

//    @TransactionalEventListener
    @Async
    @EventListener
    void handleRegistration(UserRegistrationEvent event){
        System.out.println("Registration event got triggered for customer::  " + event.getName());
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