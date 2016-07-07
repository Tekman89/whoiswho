package org.academiadecodigo.whoiswho.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codecadet on 07/07/16.
 */
public class Server {

    /*
        Multithread, reponsável pela comunicação entre game e cliente.
     */

    private final ServerSocket serverSocket;
    private final ClientManager clientManager;


    public Server(int portNumber, int maxNumber) throws IOException {
        serverSocket = new ServerSocket(portNumber);
        clientManager = new ClientManager(maxNumber, this);
        new Thread(clientManager).start();

    }

    public void host(){


        while (true){

            try{
                System.out.println("----Waiting for Connection----");

                MySpecialPThread temp = new MySpecialPThread(serverSocket.accept());

                if(clientManager.isFull()){
                    clientManager.addToQueue(temp);

                }else {
                    clientManager.addToActive(temp);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }


    private void sendAll(String line){

        synchronized ( clientManager.getActiveList()){

            for (Runnable e: clientManager.getActiveList()) {

                if(e instanceof MySpecialPThread){
                    ((MySpecialPThread) e).send(line);
                }

            }

        }
    }



    public class MySpecialPThread implements Runnable{

        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;


        private MySpecialPThread(Socket clientSocket) throws IOException {

            this.clientSocket = clientSocket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);


        }

        @Override
        public void run() {

            try{

                while (!clientSocket.isClosed()){
                    String line = "";

                    if((line = in.readLine()) != null){
                        sendAll(Thread.currentThread().getName() + ": " + line);


                        // TODO: 07/07/16 exit condition (game)
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        public void send(String toSend){
            out.write(toSend);
            out.println();
        }


    }// End of The Nested Class

}
