package com.yang.blog.controller;

import com.yang.blog.dao.LabelDao;
import com.yang.blog.pojo.House;
import com.yang.blog.pojo.Labels;
import com.yang.blog.pojo.User;
import com.yang.blog.response.ResonseState;
import com.yang.blog.response.ResponseResult;
import com.yang.blog.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    public IdWorker idWorker;
    @Autowired
    public LabelDao labelDao;
    @ResponseBody
    @GetMapping("/hello")
    public ResponseResult helloWorld(){
        System.out.println("hello,world");
       log.info("hello,world...");
        return ResponseResult.SUCCESS();
    }
    @ResponseBody
    @RequestMapping("/test-json")
    public ResponseResult testJoin(){
        User user = new User("孙悟空", 12, "男");
        House house=new House("水帘洞","花果山");
        user.setHouse(house);
        ResponseResult responseResult = new ResponseResult(ResonseState.SUCCESS);
        responseResult.setData(user);
        return responseResult;

    }
    @RequestMapping("/login")
    public ResponseResult test_Login(@RequestBody User user){
        log.info("username"+user.getName());
        log.info("password"+user.getPassword());
        ResponseResult responseResult=ResponseResult.SUCCESS("登录成功");
        responseResult.setData(user);
        return responseResult;
    }
    @PostMapping("/label")
    public ResponseResult addLabel(@RequestBody Labels labels){
        //判断数据是否有效
        //补全数据
        //保存数据
        String idword = String.valueOf(idWorker.nextId());

        labels.setId(idword);
        labels.setCreateTime(new Date());
        labels.setUpdateTime(new Date());
        labelDao.save(labels);
        return  ResponseResult.SUCCESS("保存数据成功");
    }
    @DeleteMapping("/label/{labelId}")
    public ResponseResult delLabel(@PathVariable("labelId") String labelId){

        int i = labelDao.deleteOneById(labelId);
        if (i>0){
            return ResponseResult.SUCCESS("标签删除成功");
        }else{
            return ResponseResult.FAILED("标签不存在");
        }
    }
}

