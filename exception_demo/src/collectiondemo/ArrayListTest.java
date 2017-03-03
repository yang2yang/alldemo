/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package collectiondemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dingqingli
 * @version $Id: ArrayListTest.java, v 0.1 2017年02月18日 下午8:10 qlD Exp $
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("5");
        list.add("6");
        System.out.println(list.get(0));

        Object[] o = new Object[Integer.MAX_VALUE-10];

//        System.out.println(Integer.MAX_VALUE-1000000000);
//        Object[] o = new Object[Integer.MAX_VALUE-2000000000];

//        List l2 = new ArrayList<>(Integer.MAX_VALUE - 8);
//        list.add("7");
//        System.out.println(l2.get(0));
        ArrayList arrayList = new ArrayList();
    }
}
