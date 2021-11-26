package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("c3")
public class ControllerTest2 {
    @RequestMapping("/t2")
    public String test(Model model){
        model.addAttribute("msg","ConTrollerTest2");
        return "test";
    }

}
@Controller
class Cont{
@RequestMapping("/t3")
    public String test1(Model model){
    model.addAttribute("msg","csfesfs");
    return "test";
}

}
