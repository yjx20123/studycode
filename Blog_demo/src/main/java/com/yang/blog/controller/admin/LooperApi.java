package com.yang.blog.controller.admin;

import com.yang.blog.pojo.Looper;
import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/loop")
public class LooperApi {
    @PostMapping
    public ResponseResult addLooper(@RequestBody Looper looper){
        return ResponseResult.SUCCESS();
    }

    @DeleteMapping("{looperId}")
    public ResponseResult deleteLooper(@PathVariable("looperId") String looperId) {
        return ResponseResult.SUCCESS();
    }

    @PutMapping("{looperId}")
    public ResponseResult updateLooper(@PathVariable("looperId") String looperId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("looperId")
    public ResponseResult getLooper(@PathVariable("looperId") String looperId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("/list")
    public ResponseResult Looper(@RequestParam("page")int page,@RequestParam("size") int size) {
        return ResponseResult.SUCCESS();
    }
}
