package com.lambda;

public class TestLambda2 {

    public static void main(String[] args) {

        ILove love=(int a)->{
            System.out.println("i love you!!!-->"+a);
        };
        love=(a)->{
          System.out.println("sss");
        };
        //简化库括号
        love=a->{
            System.out.println("精简2");
        };
        love=A->System.out.println("省略大括号");
        love.love(1);
        /*
        总结：
        lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行,那么就用代码块包裹
        使用lambda的前提式函数式接口
        多个参数也可以去掉参数类型，但需要要括号包裹
        
         */
    }
}
interface ILove{
    void love(int a);
}
