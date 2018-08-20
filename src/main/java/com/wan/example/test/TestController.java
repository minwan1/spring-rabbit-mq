package com.wan.example.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tests")
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(method = RequestMethod.GET)
    public String  test(){
        testService.test();
        return "zxcv";
    }
}
