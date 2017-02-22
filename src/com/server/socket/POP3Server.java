package com.server.socket;

import com.server.GUI.GUIPop3Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Igor on 22.02.2017.
 */
public class POP3Server {
    public final static Integer PORT = 110;
    public POP3Server(){

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientServerThread clientThread = new ClientServerThread(clientSocket);
                    clientThread.start();
                } catch (IOException ioe) {
                    System.out.println("Exception encountered on accept. Ignoring. Stack Trace :");
                    ioe.printStackTrace();
                }

            }
        }
        catch (IOException e){
            System.out.println("Could not create server socket at " + PORT);
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public static void main(String[] args) {
        GUIPop3Server guiPop3Server = new GUIPop3Server();
    }
}
