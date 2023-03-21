package com.recialhot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@SpringBootTest
public class KafkaTests {

    @Autowired
    private KafkaProducer kafkaProducer;


    @Test
    public void testKafka() throws InterruptedException {
        kafkaProducer.sendMessage("test","你好");
        kafkaProducer.sendMessage("test","嘿嘿");

        Thread.sleep(1000*2);
    }
}

@Component
class KafkaProducer{
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic,String content){
        kafkaTemplate.send(topic,content);
    }
}

@Component
class KafkaConsumer{

    @KafkaListener(topics = {"test"})
    public void handlerMessage(ConsumerRecord record){
        System.out.println(record.value());
    }

}
