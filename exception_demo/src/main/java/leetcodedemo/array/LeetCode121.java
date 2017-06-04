package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/6/4.
 */
public class LeetCode121 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPreNumber = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < minPreNumber) {
                for (int j = i + 1; j < prices.length; j++) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
                minPreNumber = prices[i];
            }
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int maxProfit = 0;
        int minPreNumber = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > minPreNumber) {
                maxProfit = Math.max(prices[i] - minPreNumber, maxProfit);
            } else {
                minPreNumber = prices[i];
            }
        }
        return maxProfit;
    }
}
