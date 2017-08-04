package hdfsdemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;


/**
 * Created by jack on 2017/8/3.
 */
public class HdfsRpcService implements RpcInterface{

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        Server server = new RPC.Builder(configuration)
                .setProtocol(RpcInterface.class)
                .setInstance(new HdfsRpcService())
                .setBindAddress("localhost")
                .setPort(9002)
                .build();
        server.start();
    }


    @Override
    public String saySomething(String s) {
        System.out.println(count++);
        return s;
    }
}
