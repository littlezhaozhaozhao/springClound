package com.myspringcloud.controller;

import com.myspringcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {
    @Autowired
    private HelloService helloService;

    @GetMapping("gethello")
    public String getHello(){

        return  helloService.hello();
    }
    @GetMapping("gethello/factory")
    public String getHelloFactory(){

        return  helloService.hello();
    }

}
