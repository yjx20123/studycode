package com.yjx.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] q = {2, 34, 6, 12, 3, 1, 24, 5, 3};
        int[] sort=sort(q);
        System.out.print(Arrays.toString(sort(q)));
    }

    public static int[] sort(int[] array) {
        //临时变量
        int temp = 0;
        //冒泡排序
        //外层循环，判断我们这个要走多少次
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环，比价判断两个数，如果第一个数，比第二个树大，则交换位置
            boolean flag=false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag=true;
                }

            }
            if(flag==false){
                break;
            }
        }
        return array;
    }

}
