package com.yjx.struct;

public class continueDemo {
    public static void main(String[] args) {
        int count=0;
        other:for(int i=101;i<=150;i++){
            for(int j=2;j<i;j++){
                if(i%j==0){
                    continue other;
                }
            }
            System.out.println(i);
        }
    }
}
