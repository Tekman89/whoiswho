package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;
import org.academiadecodigo.whoiswho.utilities.Characters;

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
        character = new Character.CharacterBuilder()
                .setName(name)
                .setFace(new Image("/images/" + name.toLowerCase() + ".png"))
                .setWrongFace(new Image("/images/wrongface.jpg"))
                .createCharacter();

        return character;
    }

}
