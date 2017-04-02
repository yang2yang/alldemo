package leetcodedemo.toutiao;

import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * *  author:jack 2017年03月2017/3/30日
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int numsa[] = new int[n];
        int numsb[] = new int[n];

        for (int i = 0; i < n; i++) {
            numsa[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            numsb[i] = sc.nextInt();
        }

        Point[] pn = new Point[n];

        for (int i = 0; i < n; i++) {
            pn[i] = new Point(numsa[i],numsb[i]);
        }

//        Collections.sort();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (numsa[j] >= x && numsb[j] >= y) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

class Point implements Comparator<Point>{
    int x;
    int y;

    Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
    }
}