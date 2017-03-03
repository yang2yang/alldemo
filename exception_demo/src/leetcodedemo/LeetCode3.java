package leetcodedemo;

import java.util.HashMap;
import java.util.Map;

/**
 * *  author:jack 2017年03月2017/3/2日
 */
public class LeetCode3 {
    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abc"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map map = new HashMap();
        int result = 1;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
            } else {
                result = Math.max(result, j - i);
                int chongfu = (int) map.get(s.charAt(j));
                //删除中间的数字
                for(int x =  i; x <= chongfu;x++){
                    map.remove(s.charAt(x));
                }
                i =  chongfu + 1;
                //将发现重复数字的新的值放入
                map.put(s.charAt(j),j);
            }
        }
        result = Math.max(result,s.length()- i);
        return result;
    }
}
