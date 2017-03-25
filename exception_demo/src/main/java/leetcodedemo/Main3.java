package leetcodedemo;

import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年03月2017/3/25日
*/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long nums[] = new long[n];

        for(int i = 0;i < n;i++){
            nums[i] = sc.nextInt();
        }

        for(int i = 0;i < k;i++){
            Long temp = nums[0];
            for (int j = 0; j < n; j++) {
                if(j < n -1){
                    nums[j] = nums[j] + nums[j+1];
                }else{
                    nums[j] = nums[j] + temp;
                }
                if(nums[j] > 100){
                    nums[j] = nums[j] % 100;
                }
            }
        }

        for(int i = 0;i < n;i++){
            if(i < n - 1){
                System.out.print(nums[i]+" ");
            }else{
                System.out.print(nums[i]);
            }
        }

    }


}
