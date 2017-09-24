package fastjsondemo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jack on 2017/9/15.
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("a","123");
        map.put("b","234");
        String a = JSON.toJSONString(map);
        System.out.println(a);
    }
}
