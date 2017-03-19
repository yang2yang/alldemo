package produceconsumedemo;
/**
**  author:jack 2017年03月2017/3/19日
*/
import java.util.Scanner;

import static java.lang.System.in;

public class Main2 {

    public int maxLength = -1;

    int[][] nums = new int[1000][1000];
    int[][] flag = new int[1000][1000];

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        Scanner sc = new Scanner(in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for(int i = 0;i < a;i++){
            for(int j = 0;j < b;j++){
                main2.nums[i][j] = sc.nextInt();
            }
        }

        for(int i = 0;i < a;i++){
            for(int j = 0;j < b;j++){
                main2.dfs(i,j,a,b,0);
            }
        }
        System.out.println(main2.maxLength);
    }

    public void dfs(int i,int j,int a,int b,int length){
        if(i < 0 || j < 0 || i >= a || j >= b){
            return;
        }
        maxLength = Math.max(maxLength,length+1);

        if(i+1 >= 0 && i+1 < a &&nums[i+1][j] < nums[i][j]){
            dfs(i+1,j,a,b,length+1);
        }

        if(i-1 >= 0 && i-1 < a && nums[i-1][j] < nums[i][j]){
            dfs(i-1,j,a,b,length+1);
        }

        if(j+1 >= 0 && j+1 < b && nums[i][j+1] < nums[i][j]){
            dfs(i,j+1,a,b,length+1);
        }

        if(j-1 >= 0 && j-1 < b && nums[i][j-1] < nums[i][j]){
            dfs(i,j-1,a,b,length+1);
        }
    }

    public void clear(int a,int b){
        for(int i = 0;i < a;i++){
            for(int j = 0;j < b;j++){
                flag[i][j] = 0;
            }
        }
    }
}
