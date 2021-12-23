package com.yang.blog.controller.admin;

import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin/friend_link")
public class FriendLinkApi {
    @PostMapping
    public ResponseResult addFriendLink() {
        return ResponseResult.SUCCESS();
    }

    @DeleteMapping("{friendLinkId}")
    public ResponseResult deleteFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return ResponseResult.SUCCESS();
    }

    @PutMapping("{friendLinkId}")
    public ResponseResult updateFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("friendLinkId")
    public ResponseResult getFriendLink(@PathVariable("friendLinkId") String friendLinkId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("/list")
    public ResponseResult listFriendLinks(@RequestParam("page")int page,@RequestParam("size") int size) {
        return ResponseResult.SUCCESS();
    }
}
