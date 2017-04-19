package leetcodedemo.array;

/**
**  author:jack 2017年04月2017/4/19日
*/
public class LeetCode461 {

    public static void main(String[] args) {
        LeetCode461 leetCode461 = new LeetCode461();
        System.out.println(leetCode461.hammingDistance(2,1));
    }

    public int hammingDistance(int x, int y) {
        int num = x ^ y;

        int count = 0;
        while (num != 0){
            if(num % 2 == 1){
                count++;
            }
            num = num / 2;
        }
        return count;
    }
}
