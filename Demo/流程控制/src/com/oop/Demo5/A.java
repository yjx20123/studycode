package com.oop.Demo5;

import com.oop.Demo1.Student;

public class A{
    public static void main(String[] args) {
        Person person = new B();
        person.test();
        B b = new B();
        b.test();
        ((B)person).say();
    }
}
