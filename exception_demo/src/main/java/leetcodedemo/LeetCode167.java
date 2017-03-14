package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/14日
*/
public class LeetCode167 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0,j = numbers.length - 1;i < j;){
            if(numbers[i] + numbers[j] ==  target){
                int[] result = new int[2];
                result[0] = i+1;
                result[1] = j+1;
                return result;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}
