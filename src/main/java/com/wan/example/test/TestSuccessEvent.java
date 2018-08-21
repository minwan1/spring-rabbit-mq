package com.wan.example.test;


import lombok.ToString;

import java.lang.reflect.Field;

@ToString
public class TestSuccessEvent {

    private String test;

    public TestSuccessEvent(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Class<?> thisClass = null;
        try {
            thisClass = Class.forName(this.getClass().getName());

            Field[] aClassFields = thisClass.getDeclaredFields();
            sb.append(this.getClass().getSimpleName() + " [ ");
            for(Field f : aClassFields){
                String fName = f.getName();
                sb.append("(" + f.getType() + ") " + fName + " = " + f.get(this) + ", ");
            }
            sb.append("]");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }



}
