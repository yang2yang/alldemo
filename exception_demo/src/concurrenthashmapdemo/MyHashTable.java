package concurrenthashmapdemo;
/**
**  author:jack 2017年03月2017/3/10日
*/

/**
 * 尝试仿造HashTable,做一个简单版本的只有String到String的映射把
 */
public class MyHashTable {

    private Entry[] table;

    private int capacity = 10;

    private int count = 0;

    public MyHashTable(){
        table = new Entry[capacity];
    }

    /**
     * hash函数，通过key的HashCode来获得table数组的下标
     * @param key
     * @return
     */
    private int hash(String key){
        return key.hashCode() % capacity;
    }

    /**
     * 需要加上synchronized来保证方法的线程安全
     * put函数,若相应的key值，那么就添加，如果有key，那么就更新
     * @param key
     * @param value
     */
    public synchronized void put(String key,String value){
        //需要先判断有没有哈希冲突
        int index = hash(key);
        //保存最后一个元素的引用
        Entry last = null;
        if(table[index] == null){//其实这里是可以优化掉的
            table[index] = new Entry(key,value);
            count++;
            return;
        }else{
            for(Entry entry = table[index];entry != null;entry = entry.next){
                last = entry;
                //如果key值相等就认为是一样的
                if(key.equals(entry.getKey())){
                    //更新value值
                    entry.setValue(value);
                    return;
                }
            }
        }

        //内部class的私有变量能被外部类所访问到
        last.next = new Entry(key,value);
        count++;
        return;
    }

    /**
     * 带有同步的get方法
     * @param key
     * @return
     */
    public synchronized  String get(String key){
        int index = hash(key);
        for(Entry entry = table[index];entry != null;entry = entry.next){
            if(key.equals(entry.getKey())){
                return entry.value;
            }
        }

        return null;
    }

    /**
     * 获得所有的元素的数量
     * @return
     */
    public synchronized int size(){
        return count;
    }

    public synchronized boolean containsKey(String key){
        return true;
    }


    /**
     * 单向链表
     */
    class Entry{
        private String key;
        private String value;
        /**
         * 使用拉链法解决哈希冲突
         */
        private Entry next;

        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
