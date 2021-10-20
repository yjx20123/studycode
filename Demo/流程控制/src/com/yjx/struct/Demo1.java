package com.yjx.struct;

import java.util.Scanner;

public class Demo1 {
     public static void main(String[] args) {
          Scanner scanner=new Scanner(System.in);
          String s=scanner.nextLine();
          if(s.equals("Hello")){
               System.out.println("输入的是"+s);
          }else{
               System.out.println("输入的不是hello");
          }
     }
}
