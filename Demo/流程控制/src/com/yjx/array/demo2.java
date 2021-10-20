package com.yjx.array;

public class demo2 {
    public static void main(String[] args) {
        //声明数组
        int[] array = null;
        //2:创建数组
        array = new int[10];
        array[0] = 1;
        System.out.println(array[0]);
        //java.lang.ArrayIndexOutOfBoundsException
        //数组越界
    }
}
