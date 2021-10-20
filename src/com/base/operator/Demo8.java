package com.base.operator;


import java.time.Year;
import java.util.Date;

public class Demo8 {
    public static void main(String[] args) {
        //x?y:z
        //如果x==true,则结果为y,否则为z
        int scroce=80;
       boolean a=scroce<60?true:false;
       System.out.println(a);
        Date date=new Date(1);
        System.out.println(date);
    }
}
