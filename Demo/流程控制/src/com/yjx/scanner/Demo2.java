package com.yjx.scanner;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        int i=0;
        float b=1f;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入整数");
        if (scanner.hasNextInt()){
            i=scanner.nextInt();
            System.out.println("整数类型"+i);
        }else{
            System.out.println("输入的不是整数类型");
        }
    }
}
