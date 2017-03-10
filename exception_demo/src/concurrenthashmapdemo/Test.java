package concurrenthashmapdemo;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
**  author:jack 2017年03月2017/3/10日
*/
public class Test {

    public static void main(String[] args) {
        Map concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1","a");
        concurrentHashMap.put("2","b");
        concurrentHashMap.put("3","c");

        System.out.println(concurrentHashMap.get("1"));
        System.out.println(concurrentHashMap.get("2"));
        System.out.println(concurrentHashMap.get("3"));


        Hashtable table = new Hashtable();
        table.put("1","a");
        table.put("2","b");
        table.put("3","c");

        System.out.println(table.get("1"));
        System.out.println(table.get("2"));
        System.out.println(table.get("3"));
    }
}
