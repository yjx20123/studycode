package com.yjx.array;

public class Array  {
    public static void main(String[] args) {
        int[] arrays={1,2,3,5,6,7,8,9};
        for (int x:
             arrays) {
            System.out.println(x);
        }
        for(int i=0;i<arrays.length;i++){
            System.out.print(arrays[i]+"\t");
        }
        System.out.println("=================");
        int max=arrays[0];
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        System.out.println(max);
    }
}
