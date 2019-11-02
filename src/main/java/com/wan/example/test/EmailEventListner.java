package com.wan.example.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EmailEventListner {

    @Async("threadPoolTaskExecutor")
    @TransactionalEventListener
    public void handle(EmailEvent emailEvent) throws InterruptedException {
        System.out.println("EmailEventListner start");

        System.out.println(Runtime.getRuntime().availableProcessors());



        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10000L);
        System.out.println("--------------email event--------------------");

    }
}
