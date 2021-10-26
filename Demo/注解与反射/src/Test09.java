import 反射.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test09{
//动态的创建对象，通过反射
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Class c1 = Class.forName("反射.User");
    //构造一个对象
    User user = (User) c1.newInstance();
    System.out.println(user);
    //通过构造器创建对象
//    Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//    User user2=(User) constructor.newInstance("yjx",001,18);
       //听过反射调用普通方法
    User user3=(User) c1.newInstance();
//    通过反射获取一个方法
    Method setNames = c1.getDeclaredMethod("setName", String.class);
//    invoke：激活的意思
    //(对象，“方法的值”）
    setNames.invoke(user3,"yjx");
    System.out.println(user3.getName());
}
}
