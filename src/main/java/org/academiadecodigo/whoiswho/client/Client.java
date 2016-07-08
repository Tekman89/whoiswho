package org.academiadecodigo.whoiswho.client;

import org.academiadecodigo.whoiswho.client.controllers.GameScreenController;
import org.academiadecodigo.whoiswho.client.controllers.StartingScreenController;

import java.io.*;
import java.lang.*;
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
    private boolean gameOver;
    private String answer;
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
            manager.setCharacters(characters);


            while(Navigation.getInstance().getController("startingView") == null || ((StartingScreenController) Navigation.getInstance().getController("startingView")).getManager() == null){

            }

            ((StartingScreenController)Navigation.
                    getInstance().
                    getController("startingView")).start();

            while (!socket.isClosed()) {
                String line2 = fromServer.readLine();

                if(line2 == null){
                    break;
                }
                System.out.println(line2);
                if(line2.contains("&&&&&")){
                    line2 = line2.replaceAll("&", "");
                    System.out.println("notify");
                    manager.notifyPlayer(line2);

                }
                    GameScreenController controller = (GameScreenController) Navigation.getInstance().getController("gameView");
                    controller.getChatArea().setText(line2 + "\n" + controller.getChatArea().getText());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setManager(DataManager manager) {
        this.manager = manager;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
