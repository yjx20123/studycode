package com.yjx.method;

public class Demo5 {
    public static void main(String[] args) {
       int  sum=f(100);
        System.out.println(sum);
    }
    //阶乘
    public static int f(int n){
        if(n==1){
            return 1;
        }else{
            return n*f(n-1);
        }
    }
}
