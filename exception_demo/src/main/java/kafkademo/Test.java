package kafkademo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

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

        Producer<String,String> producer = new KafkaProducer<>(props);
//        for (int i = 0; i < 100; i++) {
//            producer.send(new ProducerRecord<>("my-topic",Integer.toString(i),Integer.toString(i)));
//        }
        producer.send(new ProducerRecord<>("my-topic","mymessage2","mymessage2"));

        producer.close();
    }
}
