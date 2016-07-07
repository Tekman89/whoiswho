package org.academiadecodigo.whoiswho.server;

import org.academiadecodigo.whoiswho.utilities.Characters;

import java.net.InetAddress;
import java.util.HashMap;

/**
 * The logic of the game
 */
public class Game {
    /*
     * Responsável pelas regras, inicialmente vai escolher random o target
     * Comunicação com o server
     * Personagens de cada player
     */

    private boolean gameOver;
    private String character;
    private int lifes = 3;
    private HashMap<InetAddress, String> players;


    public Game() {

    }

    /**
     * Initializes de game
     */
    public void init() {
        character = Characters.randomCharacter().toString();
    }

    /**
     * Checks if player's answer is right
     * @param answer the player's answer
     */
    public void checkAnswer(String answer) {

        if (answer.equals(character)) {
            sendToAll("The players X won! ");
            gameOver = true;
        } else {
            if (takeLife()) {
                sendToAll("The player X didn't guess right");
            } else {
                sendToAll("The player X loose");
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
}
