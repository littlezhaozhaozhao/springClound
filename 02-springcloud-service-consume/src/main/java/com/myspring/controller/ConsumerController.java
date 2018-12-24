package com.myspring.controller;

import com.myspring.bean.User;
import com.myspring.hystrix.MyHystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

@RestController
public class ConsumerController {
    @Autowired
    private  RestTemplate  restTemplate;
//    该方法启动Hystrix熔断器功能
@HystrixCommand(fallbackMethod = "error",commandProperties  ={
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
@GetMapping("springCloud/hello")
public String hello() {
    //  ResponseEntity<String> restEntity = restTemplate.getForEntity("http://localhost:8089/hello", String.class);
    ResponseEntity<String> restEntity = restTemplate.getForEntity("http://PRIVIDER/hello", String.class);
    return   restEntity.getBody();
}
    public  String  error(Throwable throwable){
        System.out.println(throwable.getMessage());
        return  "error";
    }

    @GetMapping("getUser")
    public User  getUser(){
        Map<String,String>    parm=new HashMap<String, String>();
        parm.put("id","001");
        parm.put("name","张三");
        parm.put("gender","男");
        ResponseEntity<User> user = restTemplate.getForEntity("http://PRIVIDER/getUser?id={id}&name={name}&gender={gender}", User.class, parm);
        return user.getBody();
    }
    @PostMapping("addUser")
    public User  addUser(){
        MultiValueMap<String  ,Object>  mparm=new LinkedMultiValueMap<String, Object>();
        mparm.add("id","002");
        mparm.add("name","张三");
        mparm.add("gender","男");
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity("http://PRIVIDER/addUser", mparm, User.class);
        return        userResponseEntity.getBody();
    }
    @GetMapping("web/hystrix")
    public String  myHystrix()  throws Exception{
        MyHystrixCommand hystrix=new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        Object execute = hystrix.execute();
        return execute.toString();

    }

    /*
      用自定义HystrixCommand异步查询
     */
    @GetMapping("web/hystrixQuery")
    public String  myHystrixQuery()  throws Exception{
        MyHystrixCommand hystrix=new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
//        Object execute = hystrix.execute();
        Future queue = hystrix.queue();
        //调用完  可以写一些业务逻辑  不用等待
        //调用完直接get 可能不会立即得到结果   可能会阻塞
        String s = queue.get().toString();
        return s;
    }
}
