package org.academiadecodigo.whoiswho.server;

import org.academiadecodigo.whoiswho.utilities.Characters;

import java.net.InetAddress;
import java.util.HashMap;

/**
 * The logic of the game
 */
public class Game implements Runnable{
    /*
     * Responsável pelas regras, inicialmente vai escolher random o target
     * Comunicação com o server
     * Personagens de cada player
     */

    private Server server;
    private boolean gameOver;
    private String character;
    private int lifes = 3;
    private HashMap<InetAddress, String> players;


    public Game(Server server) {
        this.server = server;
    }

    /**
     * Initializes de game
     */
    public void init() {
        character = Characters.randomCharacter().toString();
    }

    @Override
    public void run(){

    }

    /**
     * Checks if player's answer is right
     * @param answer the player's answer
     */


    public void checkAnswer(String answer) {

        if (answer.equals(character)) {
            server.sendToAll("The players X won! ", this);
            gameOver = true;
        } else {
            if (takeLife()) {
                server.sendToAll("The player X didn't guess right", this);
            } else {
               server.sendToAll("The player X loose", this);
                gameOver = true;
            }
        }
    }

    /**
     * Decreases the number of lifes
     * @return true if lifes is bigger than zero or false if not
     */
    public boolean takeLife() {
        lifes--;
        return lifes > 0;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
