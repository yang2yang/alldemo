package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/18日
*/
public class LeetCode28 {

    public static void main(String[] args) {
        LeetCode28 leetCode28 = new LeetCode28();
        System.out.println(leetCode28.strStr("123456","23"));
    }

    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        for(int i = 0;i <= haystack.length() - needle.length();i++){
            if(haystack.substring(i,i + needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
