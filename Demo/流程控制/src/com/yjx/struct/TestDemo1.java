package com.yjx.struct;

public class TestDemo1 {
    public static void main(String[] args) {
        String s="*";
        for(int i=0;i<5;i++){
            for(int j=5;j>i;j--){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
