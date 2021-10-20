package com.oop.Demo1;
//值传递

public class Demo2 {
    public static void main(String[] args) {
        int a=0;
        Demo2.change(a);
        System.out.println(a);
    }
    public static void change(int a){
        a=10;
        return;
    }
}
