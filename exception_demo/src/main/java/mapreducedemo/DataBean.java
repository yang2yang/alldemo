package mapreducedemo;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by jack on 2017/8/7.
 */
public class DataBean implements Writable{

    /**
     * 序列化接口
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {

    }

    /**
     * 反序列化接口
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {

    }
}
