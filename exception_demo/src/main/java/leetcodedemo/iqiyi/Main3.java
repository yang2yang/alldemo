package leetcodedemo.iqiyi;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by jack-pc on 2017/5/14.
 */
//90%都超时了，时间复杂度，应该是一个递归树
public class Main3 {

    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0){
                break;
            }
            String sa = sc.nextLine();
            int[][] nums = new int[a][b];
            for (int i = 0; i < a; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < b; j++) {
                    if (s.charAt(j) == '#') {
                        nums[i][j] = 1;
                    } else {
                        nums[i][j] = 0;
                    }
                }
            }

            help(nums, a, b, a - 1, 0);

            System.out.println(result);
        }

    }

    private static void help(int[][] nums, int a, int b, int i, int j) {
        if (i < 0 || i >= a) {
            return;
        }
        if (j < 0 || j >= b) {
            return;
        }
        if (nums[i][j] == 1) {
            return;
        }
        if (i == a - 1 && j == b - 1) {
            nums[i][j] = 1;
            if (panduan(nums, a, b)) {
                result++;
            }
            nums[i][j] = 0;
            return;
        }
        nums[i][j] = 1;
        help(nums, a, b, i + 1, j);
        help(nums, a, b, i - 1, j);
        help(nums, a, b, i, j + 1);
        help(nums, a, b, i, j - 1);
        nums[i][j] = 0;
    }

    private static boolean panduan(int[][] nums, int a, int b) {
        boolean flag = true;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (nums[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
