package org.academiadecodigo.whoiswho.server;

import org.academiadecodigo.whoiswho.utilities.Characters;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Set;

/**
 * The logic of the game
 */
public class Game implements Runnable {
    /*
     * Responsável pelas regras, inicialmente vai escolher random o target
     * Comunicação com o server
     * Personagens de cada player
     */

    private String available_chars = "";
    private final int MAX_CHARACTERS = 20;
    private Server server;
    private boolean gameOver;
    private String character;
    private int lifes = 3;
    private HashMap<InetAddress, String> players = new HashMap<>();


    public Game(Server server) {
        this.server = server;
        generateCharacters();
    }


    private void generateCharacters() {
        String temp;
        for (int i = 0; i < MAX_CHARACTERS; i++) {
            temp = Characters.randomCharacter().toString();
            if (!available_chars.contains(temp)) {
                available_chars += temp + " ";
            } else {
                i--;
            }
        }
    }

    /**
     * Initializes de game
     */
    public void init() {
        character = Characters.randomCharacter().toString();
    }

    @Override
    public void run() {

    }

    /**
     * Checks if player's answer is right
     *
     * @param answer the player's answer
     */
    public boolean checkAnswer(String answer, InetAddress myAddress) {

        Set<InetAddress> set = players.keySet();

        System.out.println(players.size());

        for (InetAddress key : set) {
            if (myAddress.equals(key)) {
                continue;
            }

            if (validateAnswer(answer, players.get(key))) {
                return true;
            }
            if (!takeLife()) {
                gameOver = true;
            }

        }
        return false;
    }

    private boolean validateAnswer(String answer, String target) {
        if (!answer.equals(target)) {
            return false;
        } else return true;

    }

    /**
     * Decreases the number of lifes
     *
     * @return true if lifes is bigger than zero or false if not
     */
    public boolean takeLife() {
        lifes--;
        return lifes > 0;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getAvailable_chars() {
        return available_chars;
    }

    public void setPlayerCharacter(String name, InetAddress address) {
        players.put(address, name);
    }
}
