package com.base;

public class 标识符 {
    public static void main(String[] args){
        //标识符可以用英文大小写，下划线，以及$
        String name="孙悟空";
        String Name="孙悟空";
        String _name="唐僧";
        String $name="白龙马";
        System.out.println(name+Name+_name+$name);
        System.out.println(_name);
    }
}
