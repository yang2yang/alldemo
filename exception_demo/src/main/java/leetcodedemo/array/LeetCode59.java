package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/13.
 */
public class LeetCode59 {
    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        leetCode59.generateMatrix(2);
    }

    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int count = 1;

        int i = 0;
        int j = 0;
        int width = 0;
        while (true) {
            while (j < n - width) {
                nums[i][j++] = count++;
            }
            if(count > n * n){
                break;
            }
            //返回到原来的位置
            j--;
            i++;
            while (i < n - width) {
                nums[i++][j] = count++;
            }
            if(count > n * n){
                break;
            }
            i--;
            j--;

            while (j >= width) {
                nums[i][j--] = count++;
            }
            if(count > n * n){
                break;
            }

            j++;
            i--;
            while (i <= 1 + width) {
                nums[i--][j] = count++;
            }
            if(count > n * n){
                break;
            }
        }

        return nums;
    }
}