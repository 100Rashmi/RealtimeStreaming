package com.rashmi.socketio;


import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class SocketServer {

   SocketIOServer server;
   public SocketServer(){
       Configuration config = new Configuration();
       config.setHostname("localhost");
       config.setPort(9050);

       server = new SocketIOServer(config);
       server.start();

   }

   public SocketIOServer getServer(){
       return server;
   }
}
