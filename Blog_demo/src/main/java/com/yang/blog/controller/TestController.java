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

        ResponseResult success = ResponseResult.SUCCESS("获取成功");
        success.setData(listLabels);
        return success;
    }
    //联立模糊查询
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
            return  ResponseResult.FAILED("结果为空");
        }

        ResponseResult success = ResponseResult.SUCCESS("查询成功");
        success.setData(all);
        return success;

    }
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        // 设置字体
        specCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置
        // 设置类型，纯数字、纯字母、字母数字混合
        specCaptcha.setCharType(Captcha.TYPE_DEFAULT);
        String content = specCaptcha.text().toLowerCase();

        // 验证码存入session
//        request.getSession().setAttribute("captcha", specCaptcha.text().toLowerCase());
        //保存到Redis,十分钟有效
        createRedis.set(Constants.User.KEY_CAPTCHA_CONTENT+"123456",content,60*10);
        // 输出图片流
        specCaptcha.out(response.getOutputStream());
    }

}

