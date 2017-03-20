package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/20日
*/
public class LeetCode278 {
    public static void main(String[] args) {
        LeetCode278 leetCode278 = new LeetCode278();
        System.out.println(leetCode278.firstBadVersion(2));
    }

    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while(first < last){
            int mid = first + (last - first) / 2;
            if(!isBadVersion(mid)){
                first = mid + 1;
            }else{
                last = mid;
            }
        }
        return first;
    }
    boolean isBadVersion(int n){
        return true;
    }
}
