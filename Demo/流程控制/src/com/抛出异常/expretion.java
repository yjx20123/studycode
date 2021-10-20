package com.抛出异常;
//重写异常
public class expretion{
    String str="a"+1+2;
    String str1=1+2+"a";
    public static void main(String[] args) {
        new expretion().test();
    }
    public void test(){
        System.out.println(this.str);
        System.out.println(this.str1);
        System.out.println('a'+1+2);
    }
}
