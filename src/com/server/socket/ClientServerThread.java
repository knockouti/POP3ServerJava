package com.server.socket;

import com.server.GUI.GUIPop3Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Igor on 22.02.2017.
 */
public class ClientServerThread extends Thread {
    Socket incomingSocket;
    GUIPop3Server guiPop3Server;
    private final static String OK = "+OK ";
    private final static String ERR = "-ERR ";
    private final static String CRLF = "\r\n";

    public ClientServerThread(Socket incomingSocket, GUIPop3Server guiPop3Server) {
        this.incomingSocket = incomingSocket;
        this.guiPop3Server = guiPop3Server;

    }

    @Override
    public void run() {
        String response;
        BufferedReader in = null;
        PrintWriter out = null;
        System.out.println("Accepted Client Adress:" +
                incomingSocket.getInetAddress().getHostName());
        try {
            InputStream inputStream = incomingSocket.getInputStream();
            OutputStream outputStream = incomingSocket.getOutputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));

            out = new PrintWriter(new OutputStreamWriter(outputStream));
            response = OK + "POP3 Server Ready" + CRLF;
            sendResponse(out, response);

            StateOption sc = new StateOption();

            // Run in a loop until m_bRunThread is set to false
            while (sc.isRunnable()) {
                response = sc.parseCommand(in.readLine());
                sendResponse(out, response);

            }

            // Once outside the loop the thread will start closing
            sendResponse(out, OK + "Server closing connection" + CRLF);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.print("Stopping client thread for client");
                in.close();
                out.close();
                incomingSocket.close();
                System.out.println("...Client Thread Stopped");
            } catch (IOException ioe) {
                System.err.println(ioe.getMessage());
            } catch (NullPointerException npe) {
                System.err.println(npe.getMessage());
            }
        }
    }

    public void sendResponse(PrintWriter printWriter, String response) {

        guiPop3Server.getTextArea().append(response);

        printWriter.print(response);
        printWriter.flush();
    }

    public String parseCommand(String string) {
        String response = "";
        System.out.println(string);
        return response;
    }

}
