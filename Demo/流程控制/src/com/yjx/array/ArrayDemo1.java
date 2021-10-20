package com.yjx.array;

public class ArrayDemo1 {
    public static void main(String[] args) {
        //数组定义
        //变量的类型 变量的名字=变量的值
        int[] nums={1,2,3,5,6};//定义
//        int nums2[];//c和c++定义方法
//        nums=new int[10];//这里面可以存放10个int类型的数字
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
}
