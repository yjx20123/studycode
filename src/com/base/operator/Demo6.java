package com.base.operator;

public class Demo6 {
    public static void main(String[] args) {
        /*
        *
        * A=0011 1100
        * B=0000 1101
        *  A&B=0000 1100
        * A|B=0011 1101
        * A^B=0011 0001 //相同为零，不同为一
        * ~B=1111 0010 //相反
        * */
        System.out.println(2<<3);
        boolean a=false;
        boolean b=false;
        System.out.println(a&&b);
    }
}
