package com.kuang.pojo;

public class Proxy implements Rent{
    private Host host;
    public Proxy(Host host){
        this.host=host;
    }

    @Override
    public void rent() {
        host.rent();
    }
    //kanfang
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void hetong(){
        System.out.println("签一个租赁合同");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
