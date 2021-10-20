package com.yjx.struct;

import java.util.Scanner;

/*
 * if语句后面只可以跟一个else
 * else语句须在所有else if后面
 * 一旦其中else if 为 true 时，其他 else if 和 else 将跳过不执行
 * */
//嵌套if
public class IfDemo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的成绩：");
        int score = scanner.nextInt();

        if (score == 100) {
            System.out.println("你获得了满分呢，恭喜你！！！");

        } else if (score >= 90 && score < 100) {
            System.out.println("你获得了优秀");

        } else if (score >= 80) {
            System.out.println("你获得了良好");
        } else if (score >= 60) {
            System.out.println("你及格了");
        } else if (score < 60 && score >= 0) {
            System.out.println("你不及格");
        } else {
            System.out.println("成绩不合法");
        }
        scanner.close();
    }
}
