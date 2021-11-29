package com.yang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.pojo.User;
import com.yang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @RequestMapping(value = "/j1")

    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("sunwk", 3, "男");
        mapper.writeValueAsString(user);
        return user.toString();
    }

    @RequestMapping("/j3")
    public String json3() {
        Date date = new Date();
        System.out.println(JsonUtils.getJson(date, "YYYY-MM-dd HH:mm:ss"));
        return JsonUtils.getJson(date, "YYYY-MM-dd HH:mm:ss");
    }
}
