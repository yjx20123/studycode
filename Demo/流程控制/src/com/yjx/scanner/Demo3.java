package com.yjx.scanner;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //和
        double num = 0;
        //计算输入几个值
        int i = 1;

        while (scanner.hasNextDouble()) {
            double a = scanner.nextDouble();
            num += a;
            System.out.println(i+"个数的h和为"+num);
            i+=1;

        }
        System.out.println("平均数:"+(num/i));
    }
}
