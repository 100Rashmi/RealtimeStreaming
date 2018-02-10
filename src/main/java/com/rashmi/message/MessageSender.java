package com.rashmi.message;
import com.rashmi.kafka.MyProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MessageSender {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/rashmi/IdeaProjects/RealtimeNotifier/src/main/resources/dataFile";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String st;

        MyProducer producer = new MyProducer();
        String topic = "test";
        while((st = br.readLine()) != null){
            if( "".equals( st ) ){
                continue;
            }
            System.out.println(st);
            ProducerRecord<String, String> pr = new ProducerRecord<String, String>(topic, "client1", st);
            producer.getProducer().send(pr);

        }

    }

}
