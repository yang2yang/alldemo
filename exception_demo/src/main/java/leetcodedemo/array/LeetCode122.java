package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/5.
 */
public class LeetCode122 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int maxSoFar = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] - prices[i - 1] > 0){
                maxSoFar += prices[i] - prices[i - 1];
            }
        }
        return maxSoFar;
    }
}
