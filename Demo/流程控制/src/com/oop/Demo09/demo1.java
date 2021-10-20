package com.oop.Demo09;

public class demo1 implements UserServer {
    @Override
    public void add(String name) {
        System.out.println("add");
        return;
    }

    @Override
    public void delete(String name) {
        System.out.println("delete");
        return;
    }

    @Override
    public void update(String name) {
        System.out.println("update");
        return;
    }

    @Override
    public void get(String name) {
        System.out.println("get");
    }
}
