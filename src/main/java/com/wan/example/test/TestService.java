package com.wan.example.test;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class TestService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void test(){
        applicationEventPublisher.publishEvent(new TestSuccessEvent("zxc"));
        System.out.println("sdfasdfsdf");

    }
}
