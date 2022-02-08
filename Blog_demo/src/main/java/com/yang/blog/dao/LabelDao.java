package com.yang.blog.dao;

import com.yang.blog.pojo.Labels;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

public interface LabelDao extends JpaSpecificationExecutor<Labels>, JpaRepository<Labels,String> {
       @Modifying
        int deleteOneById(String id);
        Labels findOneByName(String name);
        Labels findAllByNameLike(String name);
}
