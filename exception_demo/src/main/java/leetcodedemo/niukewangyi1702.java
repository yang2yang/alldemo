package leetcodedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**   365
 * *  author:jack 2017年03月2017/3/24日
 */
public class niukewangyi1702 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int a = sc.nextInt();

        double r = Math.sqrt((double) a);

        int base = 0;
        int count = 0;
        int max;

        if(r == (int)r){
            max = (int)r;
            base = 4;
        }else{
            max = (int) r + 1;
        }
        //时间复杂度是r2
        for (int i = 1; i < max; i++) {
            for (int j = 1; j < max; j++) {
                if (Math.pow(i, 2) + Math.pow(j, 2) == a) {
                    count++;
                }else if(Math.pow(i, 2) + Math.pow(j, 2) > a){
                    //如果i和j的平方和大于a,那么就跳出j的循环
                    break;
                }
            }
        }

        System.out.println(count*4+base);
    }

}
