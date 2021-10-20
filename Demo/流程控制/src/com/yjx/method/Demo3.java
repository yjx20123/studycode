package com.yjx.method;

public class Demo3 {
    public static void main(String[] args) {
        Demo3 demo3=new Demo3();
        demo3.test(1);
    }
    public void test(int... i){
        System.out.println(i[0]);
    }
}
