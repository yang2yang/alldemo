package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/17日
*/
public class LeetCode9 {
    public static void main(String[] args) {
        LeetCode9 leetCode9 = new LeetCode9();
        leetCode9.isPalindrome(123321);
    }

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        if(x < 10){
            return true;
        }

        int t = x;
        int d = 0;
        //数出来数字的位数
        while(t != 0){
            t /= 10;
            d++;
        }
        //用来得到左边的最高位
        int left = (int) Math.pow(10,d - 1);
        //用来得到右边的最低位
        int right = 1;
        while(left >= right){
            //以此判断左边的数和右边的数是否相等
            if(x / left % 10 != x / right % 10){
                return false;
            }
            left /= 10;
            right *= 10;
        }
        return true;
    }
}
