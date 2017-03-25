package leetcodedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * *  author:jack 2017年03月2017/3/25日
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        Point nums[] = new Point[n];
        int numsx[] = new int[n];
        int numsy[] = new int[n];
        for (int i = 0; i < n; i++) {
            numsx[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            numsy[i] = sc.nextInt();
        }

        for(int i = 0;i < n;i++){
            nums[i] = new Point(numsx[i],numsy[i]);
        }

        int gx = sc.nextInt();
        int gy = sc.nextInt();
        Point gp = new Point(gx,gy);

        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();

        Point myPoint = new Point(0,0);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = walkTime*getTwoPoint(nums[i],myPoint);
            int b = taxiTime*getTwoPoint(nums[i],gp);
            min = Math.min(min,a+b);
        }
        min = Math.min(min,walkTime*getTwoPoint(gp,myPoint));
        System.out.println(min);
    }

    public static int getTwoPoint(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}

class Point {
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

}
