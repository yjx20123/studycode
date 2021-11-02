package function;

import java.util.function.Function;

/**
 * Function 函数型接口，有一个输入参数，有一个输出
 * 只要是函数型接口可以用lambda表达式简化
 */
public class Demo {
    public static void main(String[] args) {
//        Function function = new Function<String,String>() {
//            @Override
//            public String apply(String o) {
//                return null;
//            }
//        };
        Function function=(str)->{return str;};
        System.out.println(function.apply("ads"));
    }
}
