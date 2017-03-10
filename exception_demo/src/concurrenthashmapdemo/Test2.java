package concurrenthashmapdemo;
/**
**  author:jack 2017年03月2017/3/10日
*/
public class Test2 {

    public static void main(String[] args) {
        System.out.println("1".hashCode());
        System.out.println("1".hashCode());
        System.out.println("2".hashCode());
        System.out.println("A".hashCode());
        System.out.println('A' == 65);
        char a = 'A';
        System.out.println('A' + 'B');
        System.out.println("BYTE_MAX_VALUE=" + Byte.MAX_VALUE + "  BYTE_MIN=" + Byte.MIN_VALUE);


        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put("1","a");
        System.out.println(myHashTable.get("1"));
    }

}
