package com.yang.blog.controller.portal;

import com.yang.blog.response.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portal/article")
public class ArticlePortalApi
{
    @GetMapping("/list/{page}/{size}")
    public ResponseResult ListArticle(@PathVariable("page") int page,@PathVariable("size") int size){
        return null;
    }
    @GetMapping("list/{categoryId}/{page}/{size}")
    public ResponseResult listAractile(@PathVariable("categoryId") String categoryId,@PathVariable("page") int page,@PathVariable("size") int size){
        return null;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @GetMapping("{articleId}")
    public ResponseResult getArticleDetail(@PathVariable("articleId") String articleId){
        return null;
    }

    /**
     * 获取推荐文章
     * @param articleId
     * @return
     */
    @GetMapping("recommend/{articleId}")
    public ResponseResult getRecommentArticles(@PathVariable("articleId") String articleId){
        return null;
    }
}
