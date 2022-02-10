package com.yang.blog.dao;

import com.yang.blog.pojo.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface UserDao extends JpaSpecificationExecutor<BlogUser>, JpaRepository<BlogUser, String> {
        BlogUser findByUsername(String userName);
        BlogUser findByEmail(String email);
}


