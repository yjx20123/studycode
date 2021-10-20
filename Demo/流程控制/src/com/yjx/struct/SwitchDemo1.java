package com.yjx.struct;

import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int score=scanner.nextInt();
        //jdk7的新特性，表达式结果可以是字符串
        //字符的本质还是数字
//        反编译
        char grade='C';
        switch (grade){
            case 'A':
                System.out.println("你获得了优秀");
                break;
            default:
                System.out.println("你及格了");

        }


    }
}
