package com.wan.example.test;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.jpa.internal.schemagen.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class TransactionEventTest {

//    @Autowired
//    private ObjectMapper mapper;


    @AfterThrowing(pointcut = "@annotation(org.springframework.transaction.event.TransactionalEventListener))", throwing = "e")
    public void handleException(JoinPoint joinPoint, Throwable e) throws JsonProcessingException, ClassNotFoundException, IllegalAccessException {

        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        System.out.println("Okay - we're in the handler...");

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        final Object[] args = joinPoint.getArgs();

        for(Object obj :args){
            final String result = mapper.writeValueAsString(obj);
            System.out.println(result);
        }



        String arguments = Arrays.toString(args);
        log.info("Write something in the log... We have caught exception in method: "
                + methodName + " with arguments "
                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
                + e.getMessage(), e);
    }


}
