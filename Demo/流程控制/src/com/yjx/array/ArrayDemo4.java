package com.yjx.array;

public class ArrayDemo4 {


    public static void main(String[] args) {
        int[] arrays={1,2,3,4,5};
//        jdk1.5没有下标
//        for(int i:arrays){
//            System.out.println(i);
//        }
        //打印数组元素
//        printArray(arrays);
        printArray(reverse(arrays));
    }
    //拿到数组下标的数字
    public static void printArray(int[] arrays){
        for(int i=0;i<arrays.length;i++){
            System.out.println("array"+i+"="+arrays[i]+"\t");
        }
    }
    //反转数组的方法
    public static int[] reverse(int[] arrays){
        int[] result=new int[arrays.length];
        //反转的操作
        for(int i=0,j=result.length-1;i<arrays.length;i++,j--){
            result[j]=arrays[i];
        }

        return result;
    }
}
