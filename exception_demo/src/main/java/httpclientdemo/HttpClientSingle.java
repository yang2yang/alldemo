package httpclientdemo;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 2018/3/18.
 */
public class HttpClientSingle {
    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/tableData.json");
        List<NameValuePair> nvps = new ArrayList<>();

        long phone = 100;
        String accoutName = "zhangsanabc";

        String value = "{'phone':' " + phone + " ','accoutName':'" + accoutName + phone + "'}";

        for(int j = 0;j < 990;j++) {
            phone++;
            value += ",{'phone':' " + phone + " ','accoutName':'" + accoutName + phone + "'}";
        }

        value = "[" + value + "]";

        long count = 30;
        for (int i = 0; i < count; i++) {
            nvps.add(new BasicNameValuePair("operation", "addTableData"));
            nvps.add(new BasicNameValuePair("tableName", "jiami2"));
            nvps.add(new BasicNameValuePair("value", value));
            CloseableHttpResponse response2 = null;
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                long startTime = System.currentTimeMillis();
                response2 = httpclient.execute(httpPost);
                long endTime = System.currentTimeMillis();
                long useTime = endTime-startTime;
                System.out.println("本次执行时间为"+useTime+"毫秒,"+"约"+useTime/1000+"秒");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response2.close();
            }
            nvps.clear();
        }




    }
}
