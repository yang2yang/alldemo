package leetcodedemo;

import com.sun.xml.internal.ws.server.AbstractMultiInstanceResolver;

/**
**  author:jack 2017年03月2017/3/8日
*/
public class LeetCode121 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1;i < prices.length;i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - minPrice);
        }

        return maxProfit;
    }
}
