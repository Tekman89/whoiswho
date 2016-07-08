package org.academiadecodigo.whoiswho.server;

import org.academiadecodigo.whoiswho.utilities.Characters;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Set;

/**
 * The logic of the game
 */
public class Game {
    /*
     * Responsável pelas regras, inicialmente vai escolher random o target
     * Comunicação com o server
     * Personagens de cada player
     */

    private String available_chars = "";
    private final int MAX_CHARACTERS = 20;
    private HashMap<InetAddress, String> players = new HashMap<>();


    public Game() {
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
     * Checks if player's answer is right
     *
     * @param answer the player's answer
     */
    public boolean checkAnswer(String answer, InetAddress myAddress) {

        Set<InetAddress> set = players.keySet();

        for (InetAddress key : set) {
            if (myAddress.equals(key)) {
                continue;
            }

            if (validateAnswer(answer, players.get(key))) {
                System.out.println(players.get(key));
                return true;
            }
        }
        return false;
    }

    private boolean validateAnswer(String answer, String target) {
        return answer.equalsIgnoreCase(target);

    }


    public String getAvailable_chars() {
        return available_chars;
    }

    public void setPlayerCharacter(String name, InetAddress address) {
        players.put(address, name);
    }
}
