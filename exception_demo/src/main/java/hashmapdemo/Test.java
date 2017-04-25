package hashmapdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ding on 2017/4/25.
 */
public class Test {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        System.out.println(map.get("aaa"));
        map.put("aaa",1);
        System.out.println(map.get("aaa"));
    }
}
