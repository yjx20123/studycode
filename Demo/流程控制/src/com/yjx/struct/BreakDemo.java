package com.yjx.struct;

public class BreakDemo {
    public static void main(String[] args) {
        int i=0;
        while(i<=100){
            i++;
            if(i%10==0){

                break;
            }
            System.out.println(i);
        }
    }
}
