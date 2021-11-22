package com.kuang.jdbc;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8";
        String name="root";
        String password="root";
        //通过反射加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库,他就代表数据库
        Connection connection = DriverManager.getConnection(url, name, password);
        //像数据库发送Sql的对象Statement：CRUD
        Statement statement = connection.createStatement();
        //编写sql
        String sql="select * from smbms_user";
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
            System.out.println("birthday="+rs.getObject("birthday"));
        }
        rs.close();
        statement.close();
        connection.close();
    }
}
