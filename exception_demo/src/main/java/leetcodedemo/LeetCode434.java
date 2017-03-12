package leetcodedemo;
/**
**  author:jack 2017年03月2017/3/7日
*/
public class LeetCode434 {

    public static void main(String[] args) {
        LeetCode434 leetCode434 = new LeetCode434();
        System.out.println(leetCode434.countSegments("   "));
    }

    //开始使用的是String的spilt函数，但是发现还是有一些问题的,所以还是自己思考一个算法来进行解决
    public int countSegments(String s) {
        int count = 0;
        for(int i = 0;i < s.length();i++){
            if(i == 0){
                if(s.charAt(i) != ' '){
                    count++;
                }
            }else{
                if(s.charAt(i) != ' ' && s.charAt(i - 1) == ' '){
                    count++;
                }
            }
        }
        return count;
    }

    //后面的题解，写的比我好一丢丢
    public int countSegments2(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }
}
