package org.academiadecodigo.whoiswho.client;

import org.academiadecodigo.whoiswho.client.controllers.StartingScreenController;

import java.io.*;
import java.lang.*;
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
    private DataManager manager;
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
            String line = fromServer.readLine();
            String[] lineToFeed = line.split(" ");
            Character[] characters = new Character[lineToFeed.length];

            for (int i = 0; i <characters.length ; i++) {
                characters[i] = CharacterLoader.getInstance().loadCharacter(lineToFeed[i]);
            }
            System.out.println("Line from server: " +  line);
            manager.setCharacters(characters);


            while(Navigation.getInstance().getController("startingView") == null || ((StartingScreenController) Navigation.getInstance().getController("startingView")).getManager() == null){

            }

            System.out.println("Before: " + Navigation.getInstance().getController("startingView"));
            ((StartingScreenController)Navigation.
                    getInstance().
                    getController("startingView")).start();

            while (true) {
                String line2 = fromServer.readLine();
                //Todo send the line to the controller;
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setManager(DataManager manager) {
        this.manager = manager;
    }
}
