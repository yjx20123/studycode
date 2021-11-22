package com.kuang.jdbc;

import java.sql.*;

public class TestJdbc2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url="jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String name="root";
        String password="root";
        //通过反射加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //连接数据库,他就代表数据库
        Connection connection = DriverManager.getConnection(url, name, password);
        //编写sql
        String sql="insert into smbms_user(userName,userPassword) values(?,?)";
        //预编译sql
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setObject(1,"孙悟空");
        statement.setObject(2,"1234534");
    //执行sql
        int i = statement.executeUpdate();
        if(i>0){
            System.out.println("插入成功");
        }
        statement.close();
        connection.close();
        System.out.println("success");
    }
}
