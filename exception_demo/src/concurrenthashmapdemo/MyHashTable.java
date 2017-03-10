package concurrenthashmapdemo;
/**
**  author:jack 2017年03月2017/3/10日
*/

/**
 * 尝试仿造HashTable,做一个简单版本的只有String到String的映射把
 */
public class MyHashTable {

    private Entry[] table;

    private int Capacity = 10;

    private int index = 0;

    public MyHashTable(){
        table = new Entry[Capacity];
    }

    /**
     * hash函数，通过key的HashCode来获得table数组的下标
     * @param key
     * @return
     */
    private int hash(String key){
        return key.hashCode() % 10;
    }

    /**
     * 需要加上synchronized来保证方法的线程安全
     * @param key
     * @param value
     */
    public synchronized void put(String key,String value){
         table[hash(key)] = new Entry(key,value);
    }

    /**
     * 带有同步的get方法
     * @param key
     * @return
     */
    public synchronized  String get(String key){
        return table[hash(key)].value;
    }


    class Entry{
        public String key;
        public String value;

        public Entry(String key,String value){
            this.key = key;
            this.value = value;
        }
    }
}
