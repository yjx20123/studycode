package com.yjx.method;

public class Demo2 {
    public static void main(String[] args) {
        int result=max(2,2);
        System.out.println(result);
    }
    public  static int max(int a,int b){
        if(a==b){
            System.out.println("两数相等");
            return 0;
        }
      int result=a>b?a:b;

      return result;
    }
}
