package com.yang.service;

import com.yang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //    增加一本书
    int addBook(Books books);
    //    删除一本书
    int deleBookById(int id);
    //    更新一本书
    int updateBook(Books books);
    //    查询一本书
    Books queryBookById(int id);
    //    查询全部书
    List<Books> queryAllBook();
}
