package com.base.operator;

public class Demo5 {
    public static void main(String[] args) {
        //&&（and) ||(or) ! 与或非 取反
        boolean a=true;
        boolean b=false;
        System.out.println("a&&b"+(a&&b));
        System.out.println("a||b"+(a||b));
        System.out.println("a&&b"+(a&&b));
        //短路运算
        int c=5;
        boolean d=(c<4)&&(c++<4);
        System.out.println(c);
        System.out.println(d);
        //当第一个字段为false时，程序不会继续运行

    }
}
