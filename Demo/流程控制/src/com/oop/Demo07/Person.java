package com.oop.Demo07;

public class Person {
    {
        System.out.println("匿名代码块");
    }
    //静态代码块只执行一次
    static {
        System.out.println("静态代码块");
    }

    public Person() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.getScore();
    }
}
