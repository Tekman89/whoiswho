package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;
import org.academiadecodigo.whoiswho.utilities.PlayersEnum;

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

    public Character loadCharacter(PlayersEnum player) {

        Character character = null;

        switch (player) {
            case JOANA:
                break;
            case JORGE:
                break;
            case ANA:
                break;
            case DANIEL:
                break;
            case RALFE:
                break;
            case ELIAS:
                break;
        }

        return character;
    }

}
