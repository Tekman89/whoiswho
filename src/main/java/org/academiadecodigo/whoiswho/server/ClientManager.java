package org.academiadecodigo.whoiswho.server;

import java.util.LinkedList;

/**
 * Created by codecadet on 07/07/16.
 */
public class ClientManager implements Runnable {

    private final int MAX_NUMBER;
    private LinkedList<Server.MySpecialPThread> activeClients;
    private LinkedList<Server.MySpecialPThread> queuedClients;
    private String waitingToConnect;
    private Server myServer;


    public ClientManager(int maxNumber, Server myServer) {
        this.MAX_NUMBER = maxNumber;
        this.myServer = myServer;
        activeClients = new LinkedList<>();
        queuedClients = new LinkedList<>();
        waitingToConnect = Thread.currentThread().getName() + ": Waiting for Another Player";
    }

    @Override
    public void run() {

        try{

            synchronized (this){
                while (true){
                    while (queuedClients.size() <= 0){
                        System.out.println("Waiting empty queue");
                        wait();


                        while (isFull()){
                            System.out.println("Waiting is full");
                            wait();
                        }
                    }


                    if(!isFull()){
                        Server.MySpecialPThread temp = queuedClients.removeFirst();
                        temp.send("Connected");
                        addToActive(temp);
                        new Thread(temp).start();
                    }



                }


            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public boolean isFull() {

        synchronized (activeClients){
            activeClients.notifyAll();
            return activeClients.size() >= MAX_NUMBER;
        }

    }

    public synchronized void addToQueue(Server.MySpecialPThread myThread) {

        System.out.println("Manager: Added to Queue");
        myThread.send(waitingToConnect);
        queuedClients.add(myThread);
        notify();
    }

    public void addToActive(Server.MySpecialPThread myThread) {
        synchronized (activeClients){
            System.out.println("Manager: Added to active");
            activeClients.add(myThread);
            new Thread(myThread).start();
            activeClients.notify();
        }

    }

    public LinkedList<Server.MySpecialPThread> getActiveList() {
        return activeClients;
    }

    public synchronized void removeClient(Server.MySpecialPThread mySpecialPThread){
            activeClients.remove(mySpecialPThread);
            notifyAll();
    }

}
