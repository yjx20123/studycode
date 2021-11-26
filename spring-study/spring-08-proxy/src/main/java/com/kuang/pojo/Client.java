package com.kuang.pojo;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.seeHouse();
        proxy.fare();
        proxy.hetong();
        proxy.rent();
    }
}
