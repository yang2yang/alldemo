package leetcodedemo.iqiyi;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by jack-pc on 2017/5/14.
 */
//过了90%，但是10%超时
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int k = sc.nextInt();
        String sa = sc.nextLine();
        String s = sc.nextLine();
        String[] ss = s.split(" ");

        int i = 1;
        while (true) {
            int sum = 0;
            for (String temp : ss) {
                sum += Integer.parseInt(temp) / i;
            }
            //如果不符合k的要求
            if (sum < k) {
                break;
            }
            i++;
        }
        System.out.println(i - 1);
    }


}
