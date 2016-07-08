package org.academiadecodigo.whoiswho.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP Server which supports multi-clients, has a ClientManager to manage all it's connections
 **/
public class Server {
    private ServerSocket serverSocket;
    private ClientManager clientManager;


    public Server(int portNumber, int maxNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        clientManager = new ClientManager(maxNumber, this);
        new Thread(clientManager).start();

    }

    public void host() {

        while (true) {

            try {
                System.out.println("----Waiting for Connection----");

                MySpecialPThread temp = new MySpecialPThread(serverSocket.accept());

                clientManager.addToQueue(temp);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    public void sendToAll(String line, Game game) {

        synchronized (clientManager.getGame(game)) {

            for (Runnable e : clientManager.getGame(game)) {
                if (e instanceof MySpecialPThread) {
                    ((MySpecialPThread) e).send(line);
                }

            }
            clientManager.getGame(game).notify();
        }
    }


    public class MySpecialPThread implements Runnable {

        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;
        private Game game;


        private MySpecialPThread(Socket clientSocket) throws IOException {

            this.clientSocket = clientSocket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

        }

        @Override
        public void run() {

            try {
                System.out.println("Set UserName");
                Thread.currentThread().setName(in.readLine());
                send(game.getAvailable_chars());
                System.out.println("name set");

                while (!clientSocket.isClosed()) {
                    String line = "";

                    if ((line = in.readLine()) != null && !clientSocket.isClosed()) {
                        sendToAll(Thread.currentThread().getName() + ": " + line, game);
                        game.checkAnswer(line);

                        // TODO: 07/07/16 calls to game
                        if (game.isGameOver()) {
                            //// TODO: 07/07/16 close all active players
                            clientManager.removeGame(game);
                            break;
                        }

                    }

                }

            } catch (IOException e) {
                System.out.println("Closed");
            }


        }

        public void closeSockets(){
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setGame(Game game){
            this.game = game;
        }

        public void send(String toSend) {
            out.write(toSend);
            out.println();
        }


    }// End of The Inner Class

}
