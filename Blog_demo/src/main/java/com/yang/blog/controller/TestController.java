package com.yang.blog.controller;

import com.yang.blog.pojo.House;
import com.yang.blog.pojo.User;
import com.yang.blog.response.ResonseState;
import com.yang.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class TestController {


    @ResponseBody
    @GetMapping("/hello")
    public ResponseResult helloWorld(){
        System.out.println("hello,world");
       log.info("hello,world...");
        return ResponseResult.SUCCESS();
    }
    @ResponseBody
    @RequestMapping("/test-json")
    public ResponseResult testJoin(){
        User user = new User("孙悟空", 12, "男");
        House house=new House("水帘洞","花果山");
        user.setHouse(house);
        ResponseResult responseResult = new ResponseResult(ResonseState.SUCCESS);
        responseResult.setData(user);
        return responseResult;

    }
    @RequestMapping("/login")
    public ResponseResult test_Login(@RequestBody User user){
        log.info("username"+user.getName());
        log.info("password"+user.getPassword());
        ResponseResult responseResult=ResponseResult.SUCCESS("登录成功");
        responseResult.setData(user);
        return responseResult;
    }
}
