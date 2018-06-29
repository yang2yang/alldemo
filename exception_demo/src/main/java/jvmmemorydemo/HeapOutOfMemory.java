package jvmmemorydemo;

import java.util.ArrayList;
import java.util.List;

/**

 * @Described：堆溢出测试

 * @VM args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError

 * @author YHJ create at 2011-11-12 下午07:52:22

 * @FileNmae com.yhj.jvm.memory.heap.HeapOutOfMemory.java

 */
public class HeapOutOfMemory {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();
        int i = 0;
        while(true){
            System.out.println(i++);
            testCases.add(new TestCase());
        }
    }
}

class TestCase{

}
