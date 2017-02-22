package com.server.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Igor on 22.02.2017.
 */
public class ClientServerThread extends Thread {
    Socket incomingSocket;
    private final static String OK = "+OK ";
    private final static String ERR = "-ERR ";
    private final static String CRLF = "\r\n";

  public ClientServerThread(Socket incomingSocket){
        this.incomingSocket = incomingSocket;


  }

  @Override
  public void run(){
      String response;
      BufferedReader in;
      PrintWriter out;
      System.out.println("Accepted Client Adress:" +
              incomingSocket.getInetAddress().getHostName());
      try {
        in = new BufferedReader(new InputStreamReader(incomingSocket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(incomingSocket.getOutputStream()));
        response = OK + "Server READY" + CRLF;
        this.sendResponse(out, response);
        StateOption stateOption = new StateOption();
          while (stateOption.isRunnable()) {
              // read incoming stream
              // TODO need to change this to have parseCommand add commands to a queue which are then popped off for execution
              response = stateOption.parseCommand(in.readLine());
              sendResponse(out, response);
          }


      } catch (Exception e){
        e.printStackTrace();
      }
  }

  public void sendResponse(PrintWriter printWriter, String response){
    printWriter.print(response);
    printWriter.flush();
  }

}
