package com.yjx.array;

import java.util.Arrays;

public class ArrayDemo6 {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 84, 6, 435, 67, 3};
        //打印数组元素Array.toString
        //sort排序方法
        //升序
        Arrays.sort(a);
        Arrays.fill(a,5);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a,2));
        System.out.println(Arrays.binarySearch(a,2));

        printArray(a);

    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i == a.length - 1) {
                System.out.print(a[i] + "]");
            } else {
                System.out.print(a[i] + ", ");
            }
        }
    }
}
