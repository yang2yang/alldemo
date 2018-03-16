package fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 2017/9/15.
 */
public class FastJsonDemo {
    public static void main(String[] args) {
//        Map map666 = new HashMap();
//        String abc = "123";
//        System.out.println(JSON.toJSONString(abc));
//        map666.put("1",JSON.toJSONString(abc));
//        System.out.println(map666.get("1"));
//
//        List<String> ll = new ArrayList<>();
//        ll.add("123");
//        ll.add("234");
//        Map map2 = new HashMap();
//        map2.put("123","123");
//        map2.put("234","234");
//        Map map = new HashMap<>();
//        map.put("a","123");
//        map.put("b","234");
//        map.put("hello",ll);
//        map.put("map2",map2);
//        System.out.println(JSON.toJSON(map));
//
//        System.out.println(JSON.toJSONString(map, SerializerFeature.DisableCircularReferenceDetect));


        String a = JSON.toJSONString(null);
        System.out.println(a);

    }
}
