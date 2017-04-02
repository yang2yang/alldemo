package leetcodedemo.qunaer;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年04月2017/4/1日
*/
public class Main {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('b',1);
        map.put('c',2);
        map.put('d',3);
        map.put('e',4);
        map.put('f',5);
        map.put('g',6);
        map.put('h',7);
        map.put('i',8);
        map.put('j',9);
        map.put('k',10);
        map.put('l',11);
        map.put('m',12);
        map.put('n',13);
        map.put('o',14);
        map.put('p',15);
        map.put('q',16);
        map.put('r',17);
        map.put('s',18);
        map.put('t',19);
        map.put('u',20);
        map.put('v',21);
        map.put('w',22);
        map.put('x',23);
        map.put('y',24);
        map.put('z',25);
        Scanner sc = new Scanner(in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();

            BigInteger bigInteger = new BigInteger(String.valueOf(26));
            int count = 0;
            BigInteger sum = new BigInteger(String.valueOf(0));
            for(int i = s.length() - 1;i >= 0;i--){
                sum = sum.add(ppp(bigInteger,count).multiply(new BigInteger(String.valueOf(map.get(s.charAt(i)))))) ;
                count++;
            }
            System.out.println(sum);
        }
    }

    private static BigInteger ppp(BigInteger bigInteger,int count){
        BigInteger sum = new BigInteger(String.valueOf(1));
        for(int i = 0;i < count;i++){
            sum = sum.multiply(bigInteger);
        }
        return sum;
    }


}
