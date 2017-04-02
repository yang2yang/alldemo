package leetcodedemo.toutiao;

import java.util.Scanner;

import static java.lang.System.in;

/**
**  author:jack 2017年03月2017/3/30日
*/
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] result = new int[n];
        result[0] = result[1] = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if(n < 3){
            System.out.println("-1 -1");
            return;
        }

        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if(nums[i] > nums[i-1]){
                flag = true;
                break;
            }
        }

        if(!flag){
            System.out.println("-1 -1");
            return;
        }

        int max = 0;
        int index = 0;
        for(int i = 1;i < n;i++){
            if(nums[i] > nums[i-1]){
                result[i] = 0;
            }else if(nums[i] < nums[i-1]){
                result[i] = i - index + 1;
                max = Math.max(result[i],max);
                if(i+1 < n && nums[i] < nums[i+1]){
                    index = i;
                }
            }
        }

        if(max == 0){
            System.out.println("-1 -1");
            return;
        }

        for(int i = 0;i < n;i++){
            if(result[i] == max){
                System.out.println(i-result[i]+1+" "+i);
                return;
            }
        }

    }
}
