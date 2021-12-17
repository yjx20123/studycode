package com.yang.blog.controller;

import com.yang.blog.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println("hello,world");
        return "hello";
    }
    @ResponseBody
    @RequestMapping("/test-json")
    public User testJoin(){
        User user = new User("孙悟空", 12, "男");
        return user;

    }
}
