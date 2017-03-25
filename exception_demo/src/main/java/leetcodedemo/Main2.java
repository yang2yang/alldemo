package leetcodedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * *  author:jack 2017年03月2017/3/25日
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        String s = sc.next();

        int count = 0;
        int sum1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                sum1 = sum1 + i - count;
                count++;
            }
        }

        int sum2 = 0;
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') {
                sum2 = sum2 + s.length() -1 - i - count;
                count++;
            }
        }

        System.out.println(Math.min(sum1, sum2));
    }


}
