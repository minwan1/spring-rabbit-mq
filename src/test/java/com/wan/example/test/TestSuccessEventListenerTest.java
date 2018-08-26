package com.wan.example.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wan.example.Member;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TestSuccessEventListenerTest {

    @Test
    public void name() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Object test = null;


        System.out.println(objectMapper.writeValueAsString(test));
    }
}