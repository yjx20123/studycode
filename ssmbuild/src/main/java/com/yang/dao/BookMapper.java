package com.yang.dao;

import com.yang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
//    增加一本书
    int addBook(Books books);
//    删除一本书
    int deleBookById(@Param("bookID") int id);
//    更新一本书
    int updateBook(Books books);
//    查询一本书
    Books queryBookById(@Param("bookId") int id);
//    查询全部书
    List<Books> queryAllBook();
}
