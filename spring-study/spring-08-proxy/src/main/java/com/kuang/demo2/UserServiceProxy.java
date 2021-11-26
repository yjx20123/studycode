package com.kuang.demo2;

public class UserServiceProxy implements UserService{
    UserServiceImpl userService;

    public static void main(String[] args) {

    }

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public void add() {

        userService.add();
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void query() {

    }


    public void log(String msg){
        System.out.println("Debug"+msg+"方法");
    }
}
