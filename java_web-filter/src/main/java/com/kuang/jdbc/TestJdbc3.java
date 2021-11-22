package com.kuang.jdbc;

import javax.naming.Name;
import java.sql.DriverManager;

public class TestJdbc3 {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="root";
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection(url, username,password);
    }
}
