package com.base;

public class Demo2 {
    String name="afa";//实例变量
    static double salary=2500;//类变量
    public static void main(String[] args) {
        int i=10;//方法内属于局部变量
        System.out.println(i);
        Demo2 demo2=new Demo2();
        System.out.println(demo2.name);
        System.out.println(salary);

    }
}
