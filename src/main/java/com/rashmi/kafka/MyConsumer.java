package com.rashmi.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

public class MyConsumer {

    KafkaConsumer<String, String> consumer;
    public MyConsumer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        this.consumer = new KafkaConsumer<String, String>(props);

    }

    public KafkaConsumer<String, String> getConsumer() {
        return consumer;
    }

}
