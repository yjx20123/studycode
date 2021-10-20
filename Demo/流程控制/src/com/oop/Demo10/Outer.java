package com.oop.Demo10;

public class Outer {
    private  int id;
    public void out(){
        System.out.println("这是外部的方法");
    }
    public  class Inner{
        public void run(){
            System.out.println("这是内部的方法");
        }
        public void test(){
            System.out.println(id);
            out();
        }
    }
}
