package com.yang.blog.controller.admin;

import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/admin/image")
public class ImageApi {
    @PostMapping
    public ResponseResult uploadImage(){
        return ResponseResult.SUCCESS();
    }@DeleteMapping("{imageId}")
    public ResponseResult deleteImage(@PathVariable("imageId") String iamgeId){
        return ResponseResult.SUCCESS();
    }@PutMapping("{imageId}")
    public ResponseResult updateImage(@PathVariable("imageId") String iamgeId){
        return ResponseResult.SUCCESS();
    }@GetMapping("imageId")
    public ResponseResult getImage(@PathVariable("imageId") String iamgeId){
        return ResponseResult.SUCCESS();
    }@PostMapping
    public ResponseResult Image(){
        return ResponseResult.SUCCESS();
    }
}
