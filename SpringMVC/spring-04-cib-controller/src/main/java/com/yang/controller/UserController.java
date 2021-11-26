package com.yang.controller;

import com.yang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model, HttpSession session){
//       1、接收前端参数
        System.out.println("接收道德前端的参数为"+name);
//        2、将返回的结果传递给前端
        model.addAttribute("msg",name);
//        视图调转
        return "test";
    }
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
