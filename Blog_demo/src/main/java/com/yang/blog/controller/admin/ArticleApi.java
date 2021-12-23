package com.yang.blog.controller.admin;

import com.yang.blog.pojo.Article;
import com.yang.blog.pojo.Looper;
import com.yang.blog.response.ResonseState;
import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin/article")
public class ArticleApi {
    @PostMapping
    public ResponseResult addArticle(@RequestBody Article article){
        return ResponseResult.SUCCESS();
    }

    @DeleteMapping("{articleId}")
    public ResponseResult deleteArticle(@PathVariable("articleId") String articleId) {
        return ResponseResult.SUCCESS();
    }

    @PutMapping("{articleId}")
    public ResponseResult updateArticle(@PathVariable("articleId") String articleId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("articleId")
    public ResponseResult getArticle(@PathVariable("articleId") String articleId) {
        return ResponseResult.SUCCESS();
    }

    @GetMapping("/list")
    public ResponseResult listArticles(@RequestParam("page")int page,@RequestParam("size") int size) {

        return ResponseResult.SUCCESS();
    }
    @PutMapping("/sate/{articleId}/{state}")
    public ResponseResult updateARticleState(@PathVariable("articleId") String articleId,@PathVariable("state") String state){
        return  ResponseResult.SUCCESS();
    }
    @PutMapping("/top/{articleId}")
    public ResponseResult updateArticleState(@PathVariable("articleId") String articleId){
        return ResponseResult.SUCCESS();
    }
}
