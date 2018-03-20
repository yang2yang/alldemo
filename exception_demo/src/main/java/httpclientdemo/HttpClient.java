package httpclientdemo;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jack on 2018/3/18.
 */
public class HttpClient {
    public static void main(String[] args) throws IOException {
//        HttpGet httpGet = new HttpGet("http://targethost/homepage");
//        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
//        try {
//            System.out.println(response1.getStatusLine());
//            HttpEntity entity1 = response1.getEntity();
//             do something useful with the response body
//             and ensure it is fully consumed
//            EntityUtils.consume(entity1);
//        } finally {
//            response1.close();
//        }

        long concurentTime = System.currentTimeMillis();
        long start = 1000000;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for(long i = 0;i < 100;i++) {
            executorService.submit(new Task(start));
            start += 10000;
        }



//   500w   / 100   1w


        System.out.println(11);

        while (!executorService.isShutdown()){
            try {
                Thread.sleep(3600*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
//        System.out.println("本次总发送次数为"+ count +",本次使用时间为" + (end-concurentTime) / 1000 + "秒," + (end-concurentTime) / 1000 /60 + "分钟");
        System.out.println("本次使用时间为" + (end-concurentTime) / 1000 + "秒," + (end-concurentTime) / 1000 /60 + "分钟");

        System.out.println("结束");
    }
}


class Task implements Runnable{

    private Long start;

    public Task(Long start) {
        this.start = start;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());

            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://localhost:8090/tableData.json");
            List<NameValuePair> nvps = new ArrayList<>();

            long phone = start;
            String accoutName = "zhangsan";
            long count = 10000;
            for (int i = 0; i < count; i++) {
//                System.out.println(i);
                nvps.add(new BasicNameValuePair("operation", "addTableData"));
                nvps.add(new BasicNameValuePair("tableName", "jiami2"));
                String value = "[{'phone':' " + phone + " ','accoutName':'" + accoutName + phone + "'}]";
//                System.out.println(value);
                nvps.add(new BasicNameValuePair("value", value));
                CloseableHttpResponse response2 = null;
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                    response2 = httpclient.execute(httpPost);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    response2.close();
                }
                phone++;
                nvps.clear();

            }

            System.out.println("本线程结束");

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
