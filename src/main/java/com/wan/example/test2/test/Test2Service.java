package com.wan.example.test2.test;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class Test2Service {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void test(){
        applicationEventPublisher.publishEvent(new Test2SuccessEvent(this,"zxc"));
        System.out.println("sdfasdfsdf");

    }
}
