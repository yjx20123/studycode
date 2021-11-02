package function;

import java.util.function.Consumer;

public class Demo3 {
    public static void main(String[] args) {
        /**
         * Consumer 消费型接口： 只有输入，没有返回值
         *
         */
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        Consumer<String> consumer1=(str)->{System.out.println(str);};
        consumer.accept("adfsf");
        consumer1.accept("sfdsfsd");
    }
}
