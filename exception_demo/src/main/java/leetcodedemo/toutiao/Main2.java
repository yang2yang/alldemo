package leetcodedemo.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * *  author:jack 2017年03月2017/3/30日
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> list = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        List<String[]> list2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list2.add(list.get(i).split(" "));
        }

        for (int i = 0; i < m; i++) {
            String query = sc.nextLine();
            String[] s = query.split(" ");

            int maxCount = 0;
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (String a : s) {
                    if (have(list2.get(j),a)) {
                        count++;
                    }
                }
                if (maxCount < count) {
                    maxCount = Math.max(maxCount, count);
                    maxIndex = j;
                }
            }
            System.out.println(list.get(maxIndex));
        }
    }

    private static boolean have(String[] ss, String target) {
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equalsIgnoreCase(target)) {
                return true;
            }
        }
        return false;
    }

}
