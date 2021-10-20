package com.lambda;

/*
 * 推导lambda表达式
 * */
public class TestLambda1 {
    //3.静态内部类
    static class Like2 implements ILike {

        @Override
        public void lanbda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        Like like = new Like();
        like.lanbda();
        Like2 like2 = new Like2();
        like2.lanbda();
        //局部内部类
        class Like3 implements ILike {

            @Override
            public void lanbda() {
                System.out.println("i like lambda3");
            }
        }
        Like3 like3 = new Like3();
        like3.lanbda();
        //匿名内部类
        ILike like4 = new ILike() {

            @Override
            public void lanbda() {
                System.out.println("i like lambda4");
            }
        };
        like4.lanbda();

       ILike like5=()->{
            System.out.println("i like lamda5");
        };
       like5.lanbda();
    }
}

//定义一个函数式接口
interface ILike {
    void lanbda();
}

class Like implements ILike {

    @Override
    public void lanbda() {
        System.out.println("i like lambda");
    }
}
