package MethodParamterBy;

import java.util.Date;

/**
**  author:jack 2017年01月2017/1/7日
*/
public class Test {
    public static void main(String[] args) {
        A aa = new A();
        aa.setA(5);
        Date date = new Date("1 Apr 98999");
        Double dd = 5.0;
        String s = "123";
        changeValueA(aa,date,dd,s);
//        System.out.println(dd);
//        System.out.println(date);
        System.out.println(s);
    }

    private static void changeValueA(A aa,Date date,Double dd,String s){
        aa.setA(7);
        date.setDate(date.getDate()+1);
        dd = 7.0;
        s = "abc";
    }
}
