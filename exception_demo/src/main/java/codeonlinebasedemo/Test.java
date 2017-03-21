package codeonlinebasedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年03月2017/3/21日
*/
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int a = sc.nextInt();
        System.out.println("a = " + a);

//        while(sc.hasNextInt()){
//            System.out.println(sc.nextInt());
//        }

        for(int i = 0;i < 5;i++){
            System.out.println(sc.nextInt());
            System.out.println(sc.next());
        }
    }
}
