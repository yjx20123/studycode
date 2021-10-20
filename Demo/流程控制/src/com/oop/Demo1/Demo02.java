package com.oop.Demo1;


//引用传递
public class Demo02 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        Demo02.change(person);
        System.out.println(person.name);
    }

    public static void change(Person person) {
        //相当于Person person=new Person()
        //person是一个对象

        person.name = "yjx";
    }


}

class Person {
    String name;
}