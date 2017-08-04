package hdfsdemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by jack on 2017/8/3.
 */
public class HdfsRpcClient {

    public static void main(String[] args) throws IOException {
        RpcInterface rpc = RPC.getProxy(
                RpcInterface.class
                ,10010
                ,new InetSocketAddress("localhost",9002)
                ,new Configuration());

        String s = rpc.saySomething("hello rpc4");

        System.out.println(s);

        RPC.stopProxy(rpc);
    }

}
