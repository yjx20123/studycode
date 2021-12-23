package com.yang.blog.controller.admin;

import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/web_size_info")
public class WebSizeInfoApi {
    @PostMapping("/title")
    public RestController getWebTitle(){
        return null;
    }
    @PutMapping("/title")
    public ResponseResult upWebSizeTitle(@RequestParam("title") String title){
            return ResponseResult.SUCCESS();
    }
    @GetMapping("/seo")
    public ResponseResult getSeoInfo(){
        return null;
    }
    @PutMapping("/seo")
    public ResponseResult putSeoInfo(@RequestParam("keywords") String keywords,@RequestParam("description") String description){
        return null;
    }
    @GetMapping("/view_count")
    public ResponseResult getWebSizeViewCount(){
        return null;
    }
}
