package com.yjx.struct;

import java.util.Scanner;

public class IfDemo2 {
    public static void main(String[] args) {
        //if双选择结构
        //考试60分几个，小于60不及格
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入成绩");
        int score=scanner.nextInt();
        if(score<60){
            System.out.println("成绩不合格");
        }else{
            System.out.println("成绩合格");
        }
    }
}
