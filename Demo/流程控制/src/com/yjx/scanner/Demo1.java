package com.yjx.scanner;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        //创建一个扫描器对象，用于接收键盘数据
        System.out.println("使用nextLine接收:\n");
        Scanner scanner=new Scanner(System.in);
        //判断用户有没有输入字符串
        if(scanner.hasNextLine()){
            //使用next方式接收
            String str=scanner.nextLine();
            System.out.println("输入的内容为："+str);
        }
        //凡是属于IO流如果不关闭会一直占用资源
        scanner.close();
    }
}
