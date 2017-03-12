package jvmmemorydemo;

import java.util.ArrayList;
import java.util.List;

/**

 * @Described：堆溢出测试

 * @VM args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails

 * @author YHJ create at 2011-11-12 下午07:52:22

 * @FileNmae com.yhj.jvm.memory.heap.HeapOutOfMemory.java

 */
public class HeapOutOfMemory {
    public static void main(String[] args) {
        List<TestCase> testCases = new ArrayList<>();
        while(true){
            testCases.add(new TestCase());
        }
    }
}

class TestCase{

}
