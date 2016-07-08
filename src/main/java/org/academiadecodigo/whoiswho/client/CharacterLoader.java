package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import org.academiadecodigo.whoiswho.utilities.Characters;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

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

            character = new Character()
                    .setName(name)
                    .setFace(new Image("/images/lelito.jpg"))
                    .setWrongFace(new Image("/images/wrongface.jpg"))
                    .createCharacter();



        return character;
    }

}
