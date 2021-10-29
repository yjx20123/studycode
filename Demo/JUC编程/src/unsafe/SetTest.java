package unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Condition;

public class SetTest {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();

        //hashset
     //解决方法1   Set<s> set = Collections.synchronizedSet(new HashSet<>());
        //解决方法2
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
