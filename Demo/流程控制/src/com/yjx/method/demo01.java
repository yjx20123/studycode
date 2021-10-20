package com.yjx.method;

public class demo01 {
    public static void main(String[] args) {
    int sum=add(1,2);
    String a=add("hello,world!!");
    System.out.println(sum);
    System.out.println(a);
    test();
    }
    //加法
    //形式参数，用来调用传递给他的参数
    public static int add(int a,int b){
        return a+b;

    }
    public static void test(){
        int[] numbers= {1, 5, 3, 4, 5, 1};//定义一个数组
        //便历一个数组
        for(int i=0;i<5;i++){
            System.out.print(numbers[i]+"\t");
        }
        System.out.println("==============================");
        for(int x:numbers){
            System.out.print(x+"\t");
        }
    }
    public static String add(String a){
        return a;
    }

}
