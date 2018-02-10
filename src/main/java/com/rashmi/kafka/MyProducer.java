package com.rashmi.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Properties;

public class MyProducer {

    Producer<String, String> producer;

    public MyProducer(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        this.producer = new KafkaProducer<String, String>(props);


    }

    public Producer<String, String> getProducer() {
        return producer;
    }
}
