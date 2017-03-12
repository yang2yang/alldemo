/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package classdemo;

/**
 * @author dingqingli
 * @version testClass.java, v 0.1 2016/12/19 17:06 dingqingli Exp $
 */
public class testClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cl1 = A.class;
        Class cl2 = A.class;
        Class cl3 = Class.forName("classdemo.A");
        A a = new A();
        //使用调用Object类的getClass()方法来得到Class对象，这也是最常见的产生Class对象的方法。
        Class cl4 = a.getClass();

        //Class对象针对的是类型
        Class cl5 = int.class;

        System.out.println(cl5.getName());

        if(cl1 == cl2){
            System.out.println("cl1 == cl2");
            System.out.println("cl1 = " + cl1.getName() + " cl2 = " + cl2.getName());
        }

        if(cl1 == cl3){
            System.out.println("cl1 = " + cl1.getName() + " cl3 = " + cl3.getName());
        }
    }
}
