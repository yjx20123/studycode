package com.yang.blog.controller.portal;

import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal/comment")
public class CommentPortalApi {
    @PostMapping
    public ResponseResult PostComment() {
        return ResponseResult.SUCCESS();
    }

    @DeleteMapping("{commentId}")
    public ResponseResult deleteComment(@PathVariable("commentId") String commentId) {
        return ResponseResult.SUCCESS();
    }

    /**
     * 根据文章获取评论
     * @param articleId
     * @return
     */
   @GetMapping("/list/{articleId}")
    public ResponseResult listcoments(@PathVariable("articleId") String articleId){

        return null;
    }
}
