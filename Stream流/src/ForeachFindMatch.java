import 案例一.Person;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForeachFindMatch {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6, 8, 9, 0, 5, 6, 5);
//        Stream<Integer> stream = list.stream();
//        stream.filter(x->x>5).forEach(System.out::println);
        //案例二
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
//        List<String> list = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
//        System.out.println("高于8000块的工资"+list);
        //聚合：案例一
//        List<String> list = Arrays.asList("yjx", "sunwukong");
//        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
//        System.out.println(max.get());
        //案例二：获取Integer集合中的最大值
//        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);
//        Optional<Integer> max = list.stream().max(Integer::compareTo);
//        System.out.println(max.get());
//
//        Optional<Integer> max1 = list.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println(max1.get());
//        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
//        System.out.println(max.get().getSalary());
//        List<Integer> list = Arrays.asList(7, 5, 3, 5, 67, 5, 4, 2);
//        long count = list.stream().filter(x -> x > 2).count();
//        System.out.println("list中大于二的个数:"+count);
//        String[] strArr={"abcd","bcdd","defde","ftr"};
//        List<String> collect = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
//        System.out.println("每个元素大写"+collect);
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> integerList = list.stream().map(x -> x + 3).collect(Collectors.toList());
//        System.out.println("每个数字+3="+integerList);
        //映射
//        List<Person> people = personList.stream().map(person -> {
//            Person personNew = new Person(person.getName(), person.getSalary(), person.getAge(), person.getSex(), person.getArea());
//            personNew.setSalary(person.getSalary() + 1000);
//            return personNew;
//        }).collect(Collectors.toList());
//        System.out.println(personList.get(0));
//        System.out.println(people.get(0));
//        List<Person> personStream = personList.stream().map(person -> {
//            person.setSalary(person.getSalary() + 1000);
//            return person;
//        }).collect(Collectors.toList());
//        System.out.println(personList.get(0));
//        System.out.println(personStream.get(0));
//        将两个字符数组合并成一个新的字符数组
//        List<String> list = Arrays.asList("m,k,l,a", "1,2,3,4,5");
//        List<String> listNew = list.stream().flatMap(s -> {
//            String[] split = s.split(",");
//            Stream<String> s2 = Arrays.stream(split);
//            return s2;
//        }).collect(Collectors.toList());
//        System.out.println("处理前的集合："+list);
//        System.out.println("处理后的集合："+listNew);
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }


}
