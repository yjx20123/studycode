package com.oop;

import com.oop.Demo10.Outer;

public class Application {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.out();
        Outer.Inner inner = outer.new Inner();
        inner.run();
        inner.test();
    }
}
