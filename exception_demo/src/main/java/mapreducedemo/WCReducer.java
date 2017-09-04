package mapreducedemo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by jack on 2017/8/4.
 */
public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    protected void reduce(Text key, Iterable<LongWritable> values, Context context
    ) throws IOException, InterruptedException {



    }

}
