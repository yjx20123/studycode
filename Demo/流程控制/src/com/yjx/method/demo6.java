package com.yjx.method;

import java.util.Scanner;

public class demo6 {
    static int result;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入第一个数字");
        int a=scanner.nextInt();
        System.out.println("请输入运算符");
        String option=scanner.next();
        System.out.println("请输入第二个数字");
        int b=scanner.nextInt();
        switch (option){
            case "+":
                add(a,b);
                break;
//            case "-":
//                reduce(a,b);
//                break;
            default:
                reduce(a,b);
        }

    }
    public static int add(int a,int b){
        result=a+b;
        System.out.println(result);
        return result;
    }
    public static int reduce(int a,int b){
        result=a-b;
        System.out.println(result);
        return result;
    }


}
