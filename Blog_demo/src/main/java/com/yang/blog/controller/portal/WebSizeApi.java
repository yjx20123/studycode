package com.yang.blog.controller.portal;

import com.yang.blog.response.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/portal/web")
public class WebSizeApi {
    @GetMapping("/categories")
    public ResponseResult getCategories(){
        return null;
    }
    @GetMapping("/title")
    public ResponseResult getWebSizeTitle(){
        return null;
    }
    @GetMapping("/view_count")
    public ResponseResult getWebsizeViewCount(){
        return null;
    }
    @GetMapping("/seo")
    public ResponseResult getWebSizeSeoInfo(){
        return null;
    }
    @GetMapping("/loop")
    public ResponseResult getLoop(){
        return null;
    }
    @GetMapping("/friendLink")
    public ResponseResult getLinks(){
        return null;
    }
}
