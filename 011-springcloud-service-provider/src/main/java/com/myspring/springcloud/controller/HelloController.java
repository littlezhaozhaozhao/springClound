package com.myspring.springcloud.controller;


import com.myspring.springcloud.bean.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String helloCloud() throws InterruptedException {
        //Thread t=new Thread();
       // t.sleep(2000);
         int a= 7/0;
        return "hello Spring Cloud 8090";
    }
    @GetMapping("getUser")
    public User getUser(@RequestParam("id") String  id,
                        @RequestParam("name") String name,
                        @RequestParam("gender")String  gender
    ){
        User  user=new User();
        user.setGender(gender);
        user.setId(id);
        user.setName(name);
        return user;
    }
    @PostMapping("addUser")
    public User  addUser(@RequestParam("id") String  id,
                         @RequestParam("name") String name,
                         @RequestParam("gender")String  gender){
        User  user=new User();
        user.setGender(gender);
        user.setId(id);
        user.setName(name);
        return user;
    }
}
