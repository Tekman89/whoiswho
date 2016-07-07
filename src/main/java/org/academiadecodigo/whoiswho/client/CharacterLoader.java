package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;

/**
 * Created by dmaia on 07-07-2016.
 */
public final class CharacterLoader {

    private static CharacterLoader instance = null;

    private CharacterLoader(){

    }

    public synchronized static CharacterLoader getInstance() {

        if(instance == null){
            instance = new CharacterLoader();
        }

        return instance;
    }

    public Character loadCharacter(String name) {

        Character character = null;

        switch (name) {
            case "JOANA":
                character = new Character()
                        .setName("Joana")
                        .setHint("Sempre Contente!")
                        .setFace(new Image("/images/lelito.jpg"))
                        .setWrongFace(new Image("/images/wrongface.jpg"))
                        .createCharacter();
                break;
            case "JORGE":
                break;
            case "ANA":
                break;
            case "DANIEL":
                break;
            case "RALFE":
                break;
            case "ELIAS":
                break;
        }

        return character;
    }

}
