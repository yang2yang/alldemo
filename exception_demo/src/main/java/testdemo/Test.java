package testdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack-pc on 2017/5/27.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        System.out.println(test.getRepeatElementsNumber(list1,list2));
    }

    public int getRepeatElementsNumber(List<Integer> list1, List<Integer> list2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), 1);
        }

        int count = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (map.get(list2.get(i)) != null) {
                count++;
            }
        }
        return count;
    }
}
