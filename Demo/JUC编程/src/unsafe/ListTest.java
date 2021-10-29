package unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//java.util.ConcurrentModificationException并发修改异常！！！！！
public class ListTest{
    public static void main(String[] args) {
//        List<String> list= Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
//        List list = new ArrayList<>();
        /**
         * 并发下ArrayList 是不安全的
         * 解决方案
         * 1、vector解决
         *
         */
//     1. List<String> list=new Vector<>();
//     2 .  List<String> list=Collections.synchronizedList(new ArrayList<>());
        //3.List<String> list=new CopyOnWriteArrayList<>();
        //CopyOnwrite写入时复制 COW 计算机程序设计领域的一种优化策略
        //多个线程调用的时候,list读取的时候,固定的,写入(覆盖)
        //在写入的时候避免覆盖,造成数据问题
        //读写分离
        //CopyOnWriteArrayList比Vector Nb在哪里

        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
