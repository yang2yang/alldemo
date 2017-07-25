package java8foreachdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2017/7/12.
 */
public class ListForeach {

    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

//        items.forEach(item->System.out.println(item));


//        items.forEach(item->{
//            if("C".equals(item)){
//                System.out.println(item);
//            }
//        });

        new Thread(() -> System.out.println(123123213)).start();

    }


}
