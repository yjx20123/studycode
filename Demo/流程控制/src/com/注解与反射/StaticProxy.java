package com.注解与反射;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        DaiLi daiLi = new DaiLi(you);
        daiLi.HappyMarry();
        new Thread(()->System.out.println("woaini")).start();
    }
}

interface Marry {
    void HappyMarry();
}

class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("孙悟空是齐天大圣");
    }
}

//代理角色
class DaiLi implements Marry {
    private Marry target;

    public DaiLi(Marry target) {
        this.target = target;
    }

    public DaiLi() {

    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("前面");
    }

    private void after() {
        System.out.println("后面");
    }
}


