package leetcodedemo.array;

/**
 * Created by jack-pc on 2017/5/31.
 */
public class LeetCode495 {
    public static void main(String[] args) {

    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            sum += Math.min(timeSeries[i] - timeSeries[i - 1],duration);
        }
        return sum + duration;
    }
}
