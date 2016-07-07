package org.academiadecodigo.whoiswho.server;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by codecadet on 07/07/16.
 */
public class ClientManager implements Runnable {

    private final int MAX_GAMES;
    private final int MAX_PLAYER_GAME = 2;
    private HashMap<Game,LinkedList<Server.MySpecialPThread>> games;
    private LinkedList<Server.MySpecialPThread> queuedClients;
    private String waitingToConnect;
    private Server server;


    public ClientManager(int maxGames, Server server) {
        this.MAX_GAMES = maxGames;
        queuedClients = new LinkedList<>();
        waitingToConnect = Thread.currentThread().getName() + ": Waiting for Another Player";
        this.server = server;
        games = new HashMap<>();
    }

    @Override
    public void run() {

        try{
            synchronized (queuedClients){
                while (true){
                    while (queuedClients.size() < MAX_PLAYER_GAME){
                        System.out.println("Waiting empty queue");
                        queuedClients.wait();


                        while (games.size() >= MAX_GAMES){
                            System.out.println("Waiting is full");
                         queuedClients.wait();
                        }
                    }

                    if(games.size() < MAX_GAMES && queuedClients.size() >= MAX_PLAYER_GAME){
                        System.out.println("Start Game");
                        startGame();
                    }

                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void startGame(){
        synchronized (queuedClients) {
            Game game = new Game(server);
            System.out.println(game);
            Server.MySpecialPThread p1 = queuedClients.getFirst();
            queuedClients.remove(p1);
            Server.MySpecialPThread p2 = queuedClients.getFirst();
            queuedClients.remove(p2);
            LinkedList<Server.MySpecialPThread> provisoGame = new LinkedList<>();
            provisoGame.add(p1);
            provisoGame.add(p2);
            games.put(game, provisoGame);
            p1.setGame(game);
            p2.setGame(game);
            new Thread(game).start();
            new Thread(p1).start();
            new Thread(p2).start();
            queuedClients.notify();
        }

    }

    public void addToQueue(Server.MySpecialPThread myThread) {

        synchronized (queuedClients) {
            System.out.println("Manager: Added to Queue");
            myThread.send(waitingToConnect);
            queuedClients.add(myThread);
           queuedClients.notify();
        }
    }


    public LinkedList<Server.MySpecialPThread> getGame(Game game) {
        return games.get(game);
    }

    public void removeGame(Game game) {
        synchronized (games) {
            games.remove(game);
            games.notifyAll();
        }
    }
}
