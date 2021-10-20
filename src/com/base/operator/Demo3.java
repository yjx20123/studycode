package com.base.operator;

public class Demo3 {
    public static void main(String[] args) {
        //++ -- 自增 自减
        int a = 10;
        int b = a++;//a++是先给b赋值，之后在自增
         System.out.println(a);
        int c = ++a;//++a是a先自增，然后在给c赋值
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
