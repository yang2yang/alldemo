package kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by jack on 2017/7/26.
 */
public class Test {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("acks","all");
        props.put("retries","0");
        props.put("batch.size","16384");
        props.put("linger.ms","1");
        props.put("buffer.memory","335544");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        long currentTimeStart = System.currentTimeMillis();
        long messageNumber = 10000000;
        Producer<String,String> producer = new KafkaProducer<>(props);
        List<Stats> timeResult = new ArrayList<>();

        for (long i = 1; i < messageNumber+1; i++) {
            producer.send(new ProducerRecord<>("my-topic","1234567891234567891234567891234567891234567891234567891234568912345678912345678912345678912345678912123456789123456789123456789123456789123456789123456789123456891234567891234567891234567891234567891212345678912345678912345678912345678912345678912345678912345689123456789123456789123456789123456789121234567891234567891234567891234567891234567891234567891234568912345678912345678912345678912345678912123456789123456789123456789123456789123456789123456789123456891234567891234567891234567891234567891212345678912345678912345678912345678912345678912345678912345689123456789123456789123456789123456789121234567891234567891234567891234567891234567891234567891234568912345678912345678912345678912345678912123456789123456789123456789123456789123456789123456789123456891234567891234567891234567891234567891212345678912345678912345678912345678912345678912345678912345689123456789123456789123456789123456789121234567891234567891234567891234567891234567891234567891234568912345678912345678912345678912345678912"));
            if(i % 100000 == 0){
                Long currentTimeEnd = System.currentTimeMillis();
                timeResult.add(new Stats(currentTimeEnd,i));
            }
        }

        for (Stats stats : timeResult) {
            System.out.println("本次测试结果"+ stats.getMessageNumber()
                    + "messages," + (stats.getCurrentTime() - currentTimeStart) / 1000 + "秒,"
                    + stats.getMessageNumber()/((stats.getCurrentTime() - currentTimeStart) / 1000) +"messages/s");
        }

        producer.close();
    }
}
