package com.yang.blog.controller.admin;

import com.yang.blog.pojo.Category;
import com.yang.blog.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 分类api
 */
@Slf4j
@RestController
@RequestMapping("/admin/category")
public class CategoryAdminApi {
    /**
     * 添加分类
     *
     * @param category
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody Category category) {
        return null;
    }

    /**删除分类
     *
     * @param categoryId
     * @return
     */
    @DeleteMapping("{categoryId}")
    public ResponseResult delectCategory(@PathVariable("categoryId") String categoryId) {
        return null;
    }

    /**
     * 修改分类
     *
     * @param categoryId
     * @param category
     * @return
     */
    @PutMapping("{categoryId}")
    public ResponseResult updateCategory(@PathVariable("categoryId") String categoryId, Category category) {
        return null;
    }

    /**
     * 获取单个分类
     * @param categoryId
     * @return
     */
    @GetMapping("/{categoryId}")
    public ResponseResult getCategory(@PathVariable("categoryId") String categoryId) {
        return null;
    }
    /**获取全部分类
     *
     */
    @GetMapping("/list")
    public  ResponseResult listCategories(@RequestParam("page") int page,@RequestParam("size") int size){
        return null;
    }
}
