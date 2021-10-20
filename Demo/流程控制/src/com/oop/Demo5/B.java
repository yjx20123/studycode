package com.oop.Demo5;
//重写都是方法的重写, 和方法无关
public class B extends Person{
    @Override
    public void test() {
        System.out.println("我是子类的方法");
    }
    public void say(){
        System.out.println("我说了一句话。。。。");
    }
}

