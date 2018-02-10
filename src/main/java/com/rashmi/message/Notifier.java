package com.rashmi.message;

import com.rashmi.kafka.MyConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

public class Notifier {

    public static void main(String[] args){
        MyConsumer consumer  = new MyConsumer();
        KafkaConsumer<String, String> kafkaConsumer = consumer.getConsumer();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while(true){
            ConsumerRecords<String, String> records = kafkaConsumer.poll(200);
            for(ConsumerRecord<String, String> record: records){
                System.out.println(record.value());

            }

        }

    }
}
