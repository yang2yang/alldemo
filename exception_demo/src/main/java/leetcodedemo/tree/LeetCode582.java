package leetcodedemo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack-pc on 2017/5/16.
 */
public class LeetCode582 {
    public static void main(String[] args) {

    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            map.put(pid.get(i), ppid.get(i));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < pid.size(); i++) {
            if (isFuHe(pid.get(i), kill,map)) {
                result.add(pid.get(i));
            }
        }
        return result;
    }

    private boolean isFuHe(Integer abc, Integer kill,Map<Integer,Integer> map) {
        while (abc != 0) {
            if (abc.equals(kill)) {
                return true;
            }
            abc = map.get(abc);
        }
        return false;
    }
}
