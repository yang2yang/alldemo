package java8feature;

import com.mysql.jdbc.StringUtils;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by qingli.ding on 2018/6/29.
 */
public class Test {

    public static void main(String[] args) {
        test(() -> {
            System.out.println("abc123");
            System.out.println(123);
        });

        int result = test2((int param) -> param, 7);
        System.out.println(result);

        List list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(5);
//        Collections.sort(list,);
//        list.sort();

        List<String> str = Arrays.asList("a", "c", "d", "b");
        str.sort(String::compareToIgnoreCase);

        str.forEach(System.out::println);

//        测试forEach为null
//        List list1 = null;
//        list1.forEach(System.out::println);


        //排序
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Apple a3 = new Apple(3);
        Apple a4 = new Apple(4);

        List<Apple> apples = new ArrayList<>();
        apples.add(a2);
        apples.add(a1);
        apples.add(a4);
        apples.add(a3);

        apples.sort(Comparator.comparingInt(Apple::getWeight).reversed());

        apples.forEach(apple -> System.out.println("apple:" + apple.getWeight()));

        List<Apple> test = apples.stream().filter(apple -> apple.getWeight() == 2).collect(toList());
        test.forEach(apple -> System.out.println(apple.getWeight()));

        List<Integer> test2 = apples.stream().map(Apple::getWeight).collect(toList());

        List<String> words = Arrays.asList("hello", "world");
        List<Stream<String>> a = words.stream().map(s -> s.split("")).map(Arrays::stream).collect(toList());

        a.forEach(littleStream -> {
            List<String> littleList = littleStream.collect(toList());
            littleList.forEach(System.out::println);
            System.out.println(111);
        });

//        words.stream().map(s -> s.split("")).flatMap();
    }

    public static void test(Test2Interface test2Interface) {
        test2Interface.test();
    }

    public static int test2(Test3Interface test3Interface, int param) {
        return test3Interface.test(param);
    }
}
