package com.oop.Demo2;

public class Person {
    //一个类即使什么都不写，他也会存在一个方法
    //显示的定义构造器

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //实例化初始值
    /*
    * 1、使用new关键字，本质是在调用构造器
    * 2，
    *
    * */
    public Person(){

    }
    public Person(String name){
        this.name=name;
    }
}
