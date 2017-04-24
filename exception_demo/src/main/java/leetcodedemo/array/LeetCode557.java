package leetcodedemo.array;

/**
 * *  author:jack 2017年04月2017/4/24日
 */
public class LeetCode557 {
    public static void main(String[] args) {
        System.out.println("123".substring(0,2));
        LeetCode557 leetCode557 = new LeetCode557();
        System.out.println(leetCode557.reverseWords("abc def ghi"));
    }

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String result = "";
        for (String a : ss) {
            result += revearse(a) + " ";
        }
        return result.substring(0,result.length() - 1);
    }


    private String revearse(String a){
        String result = "";
        for(int i = a.length() - 1;i >= 0;i--){
            result += a.charAt(i);
        }
        return result;
    }
}
