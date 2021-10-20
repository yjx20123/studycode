package com.yjx.struct;

public class Fordemo2 {
    public static void main(String[] args) {
        int[] numbers= {1, 5, 3, 4, 5, 1};//定义一个数组
        //便历一个数组
        for(int i=0;i<5;i++){
            System.out.print(numbers[i]+"\t");
        }
        System.out.println("==============================");
        for(int x:numbers){
            System.out.print(x+"\t");
        }
    }
}
