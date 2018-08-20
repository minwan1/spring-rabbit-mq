package com.wan.example.test2.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class Test2SuccessEventListener implements ApplicationListener<Test2SuccessEvent> {

    @TransactionalEventListener
    void handleRegistration(Test2SuccessEvent event){
        System.out.println("zxcv");
    }

    @Override
    public void onApplicationEvent(Test2SuccessEvent test2SuccessEvent) {
        System.out.println("Registration event got triggered for customer::  " + test2SuccessEvent.getTest());
        System.out.println("zxcxzcaa11");
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
