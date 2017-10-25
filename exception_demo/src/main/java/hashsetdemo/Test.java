package hashsetdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jack on 2017/10/23.
 */
public class Test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("first");
        set.add("second");
        set.add("third");

        for(String s : set){
            System.out.println(s);
        }
    }
}
