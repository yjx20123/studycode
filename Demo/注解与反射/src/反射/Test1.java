package 反射;
//什么叫反射
 class Test1
{
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获得类的class对象
        Class c1 = Class.forName("反射.User");
        System.out.println(c1);
        Class c2 = Class.forName("反射.User");
        Class c3 = Class.forName("反射.User");
        Class c4 = Class.forName("反射.User");
        //一个类在内存中只有一个class对象
        // 一个类被加载后，类的整个结构都会被封装在class中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());

    }
}
