package com.yang.pojo;

import org.springframework.beans.factory.annotation.Autowired;

public class People {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Cat getCat() {
        return cat;
    }



    public Dog getDog() {
        return dog;
    }



    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}
