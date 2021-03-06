package com.yang.blog.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import com.yang.blog.dao.LabelDao;
import com.yang.blog.pojo.House;
import com.yang.blog.pojo.Labels;
import com.yang.blog.pojo.User;
import com.yang.blog.response.ResonseState;
import com.yang.blog.response.ResponseResult;
import com.yang.blog.utils.Constants;
import com.yang.blog.utils.IdWorker;
import com.yang.blog.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    public IdWorker idWorker;
    @Autowired
    public LabelDao labelDao;
    @Autowired
    private RedisUtil createRedis;
    @ResponseBody
    @GetMapping("/hello")
    public ResponseResult helloWorld(){
        System.out.println("hello,world");
       log.info("hello,world...");
        String captcha = (String) createRedis.get(Constants.User.KEY_CAPTCHA_CONTENT + "123456");
        log.info(captcha);
        ResponseResult success = ResponseResult.SUCCESS();
        success.setData(captcha);
        return success;
    }
    @ResponseBody
    @RequestMapping("/test-json")
    public ResponseResult testJoin(){
        User user = new User("?????????", 12, "???");
        House house=new House("?????????","?????????");
        user.setHouse(house);
        ResponseResult responseResult = new ResponseResult(ResonseState.SUCCESS);
        responseResult.setData(user);
        return responseResult;

    }
    @RequestMapping("/login")
    public ResponseResult test_Login(@RequestBody User user){
        log.info("username"+user.getName());
        log.info("password"+user.getPassword());
        ResponseResult responseResult=ResponseResult.SUCCESS("????????????");
        responseResult.setData(user);
        return responseResult;
    }
    @PostMapping("/label")
    public ResponseResult addLabel(@RequestBody Labels labels){
        //????????????????????????
        //????????????
        //????????????
        String idword = String.valueOf(idWorker.nextId());

        labels.setId(idword);
        labels.setCreateTime(new Date());
        labels.setUpdateTime(new Date());
        labelDao.save(labels);
        return  ResponseResult.SUCCESS("??????????????????");
    }
    @DeleteMapping("/label/{labelId}")
    public ResponseResult delLabel(@PathVariable("labelId") String labelId){

        int i = labelDao.deleteOneById(labelId);
        if (i>0){
            return ResponseResult.SUCCESS("??????????????????");
        }else{
            return ResponseResult.FAILED("???????????????");
        }
    }
    @GetMapping("/label/list/{page}/{size}")
    public ResponseResult listLabels(@PathVariable("page") int page,@PathVariable("size") int size){
        if(page<1){
            page=1;
        }
        if(size<=0){
            size= Constants.DEFAULT_SIZE;
        }
        Sort sort=new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable= PageRequest.of(page-1,size,sort);
        Page<Labels> listLabels = labelDao.findAll(pageable);

        ResponseResult success = ResponseResult.SUCCESS("????????????");
        success.setData(listLabels);
        return success;
    }
    //??????????????????
    @GetMapping("/label/search")
    public ResponseResult doLabelSearch(@RequestParam("keyword") String keyword,@RequestParam Integer count){
        List<Labels> all = labelDao.findAll(new Specification<Labels>() {
            @Override
            public Predicate toPredicate(Root<Labels> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate name = criteriaBuilder.like(root.get("name").as(String.class), "%"+keyword+"%");
                Predicate countname = criteriaBuilder.equal(root.get("count").as(Integer.class), count);
                Predicate andName = criteriaBuilder.and(name, countname);
                return andName;
            }
        });
        if(all==null||all.size()==0){
            return  ResponseResult.FAILED("????????????");
        }

        ResponseResult success = ResponseResult.SUCCESS("????????????");
        success.setData(all);
        return success;

    }
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ????????????????????????????????????
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // ???????????????????????????????????????
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // ????????????
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // ????????????????????????????????????
        // ?????????????????????????????????????????????????????????
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);
        String content = specCaptcha.text().toLowerCase();

        // ???????????????session
//        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        //?????????Redis,???????????????
        createRedis.set(Constants.User.KEY_CAPTCHA_CONTENT+"123456",content,60*10);
        // ???????????????
        specCaptcha.out(response.getOutputStream());
    }

}

