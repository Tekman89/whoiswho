package org.academiadecodigo.whoiswho.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by codecadet on 07/07/16.
 */
public class Client implements Runnable {

    /*
        Falar com servidor e trabalhar a visualização do user.
        Tem o player.
     */

    private Socket socket;
    private PrintWriter toServer;
    private BufferedReader fromServer;
    //controller;


    public Client(int port, String host) throws IOException {
        socket = new Socket(host, port);
        toServer = new PrintWriter(socket.getOutputStream(), true);
        fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendToServer(String toSend) {
        toServer.write(toSend);
        toServer.println();
    }


    @Override
    public void run() {
        try {
            while (true) {
                String line = fromServer.readLine();
                //Todo send the line to the controller;
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
