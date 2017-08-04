package hdfsdemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Created by jack on 2017/8/2.
 */
public class HdfsAPIDemo {

    public static void main(String[] args) throws Exception {
        putFile();
    }

    /**
     * 将本地源文件上传到hdfs的目标文件中
     * @throws Exception
     */
    public static void putFile() throws Exception{
        FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9001"),new Configuration());
        fs.copyFromLocalFile(new Path("/temptemp.txt"),new Path("/temptemp.txt"));
    }

    /**
     * 显示特定hdfs的目录下面的文件
     * @throws Exception
     */
    public static void listFiles() throws Exception{
        FileSystem fs = FileSystem.get(new URI("hdfs://localhost:9001"),new Configuration());
        FileStatus[] list = fs.listStatus(new Path("/"));
        for (FileStatus f:list) {
            System.out.println(f.getPath());
        }
    }

}
