package com.rashmi.message;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.rashmi.kafka.MyConsumer;
import com.rashmi.socketio.SocketServer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

public class Notifier {

    public static void main(String[] args){
        final SocketServer server = new SocketServer();

        server.getServer().addEventListener("clientName", String.class, new DataListener<String>() {
            public void onData(SocketIOClient socketIOClient, String data, AckRequest ackRequest) throws Exception {

                System.out.println("Adding this client to the room: "+data);
                socketIOClient.joinRoom(data);

            }
        });

        MyConsumer consumer  = new MyConsumer();
        KafkaConsumer<String, String> kafkaConsumer = consumer.getConsumer();
        kafkaConsumer.subscribe(Arrays.asList("test"));
        while(true){
            ConsumerRecords<String, String> records = kafkaConsumer.poll(200);
            for(ConsumerRecord<String, String> record: records){

                server.getServer().getRoomOperations(record.key()).sendEvent("progressData", String.valueOf(record.value()));

                //server.getServer().getBroadcastOperations().sendEvent("progressData", String.valueOf(record.value()));
               

                System.out.println(record.value());

            }

        }

    }
}
