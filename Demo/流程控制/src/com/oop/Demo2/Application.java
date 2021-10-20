package com.oop.Demo2;

public class Application {
    public static void main(String[] args) {
        //使用new关键字实例化
        Person person=new Person();
        System.out.println(person.name);
        Person person1=new Person("xi奥明");
        System.out.println(person1.name);
    }

}
