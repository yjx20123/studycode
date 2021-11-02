package function;

import java.util.function.Supplier;

public class Demo4 {
    /**
     * Supplier 没有参数，只有返回值
     */
    public static void main(String[] args) {
//        Supplier<Integer> supplier = new Supplier<Integer>() {
//
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };
        Supplier supplier1=()->{ return 1024; };
        System.out.println(supplier1.get());
    }
}
