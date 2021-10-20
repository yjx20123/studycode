package com.oop.Demo07;

public class Student {


    private  static   int age=11;//静态变量

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Student.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private   double score;//非静态变量
    public void run(){

    }
    public static void main(String[] args) {
        System.out.println(age);
        Student student = new Student();
        student.score=1.1;
        System.out.println(student.score);

    }
}
