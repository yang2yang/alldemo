/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package GenericTest;


/**
 * @author dingqingli
 * @version GenericTest.java, v 0.1 2017/1/10 12:50 dingqingli Exp $
 */
public class GenericTest {
    public static void main(String[] args) {
        People people = new People();
        people.setName("Hello");
        people.setAge(18);
//        testGeneric(people);
        testGeneric2(people);
    }


    private static <T extends PeopeoInterface> void testGeneric(T t) {
        System.out.println("start");
        System.out.println(t.getName());
    }

    private static <T extends PeopeoInterface> void testGeneric2(T t) {
        System.out.println("start");
        System.out.println(t);
    }

}
