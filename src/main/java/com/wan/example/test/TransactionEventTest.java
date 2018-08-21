package com.wan.example.test;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class TransactionEventTest {


    @AfterThrowing(pointcut = "@annotation(org.springframework.transaction.event.TransactionalEventListener))", throwing = "e")
    public void handleException(JoinPoint joinPoint, Throwable e) {

        System.out.println("Okay - we're in the handler...");

        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        String stuff = signature.toString();
        final Object[] args = joinPoint.getArgs();


        String arguments = Arrays.toString(args);
        log.info("Write something in the log... We have caught exception in method: "
                + methodName + " with arguments "
                + arguments + "\nand the full toString: " + stuff + "\nthe exception is: "
                + e.getMessage(), e);
    }


}
