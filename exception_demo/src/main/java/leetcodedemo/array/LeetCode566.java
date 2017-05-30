package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/5/30.
 */
public class LeetCode566 {
    public static void main(String[] args) {
        int[][] nums = new int[2][3];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[0][2] = 3;
        nums[1][0] = 4;
        nums[1][1] = 5;
        nums[1][2] = 6;
        new LeetCode566().matrixReshape(nums,3,2);
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null){
            return null;
        }
        if(nums.length * nums[0].length != r * c){
            return nums;
        }

        int x = 0;
        int y = 0;
        int[][] result = new int[r][c];
        for(int i = 0;i < result.length;i++){
            for(int j = 0;j < result[0].length;j++){
                result[i][j] = nums[x][y];
                if(y < nums[0].length - 1){
                    y++;
                }else{
                    x++;
                    y = 0;
                }
            }
        }

        return result;
    }
}
