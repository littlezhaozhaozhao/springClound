package com.myspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyHrstrixDashboard {
    @GetMapping("hystrix.stream")
    public  String  hystrixStream(){
        return "";
    }

}
