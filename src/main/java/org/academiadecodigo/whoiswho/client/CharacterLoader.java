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

        String[] toFeed = name.split(" ");

        for (int i = 0; i < toFeed.length ; i++) {
            character = new Character()
                    .setName(toFeed[i])
                    .setHint("Sempre Contente!")
//                    .setFace(new Image("/images/" + toFeed[i] + ".jpg"))
                    .setFace(new Image("/images/lelito.jpg"))
                    .setWrongFace(new Image("/images/wrongface.jpg"))
                    .createCharacter();
        }


//        switch (name) {
////            case "JOANA":
////                character = new Character()
////                        .setName("Joana")
////                        .setHint("Sempre Contente!")
////                        .setFace(new Image("/images/lelito.jpg"))
////                        .setWrongFace(new Image("/images/wrongface.jpg"))
////                        .createCharacter();
////                break;
////            case "JORGE":
////                break;
////            case "ANA":
////                break;
////            case "DANIEL":
////                break;
////            case "RALFE":
////                break;
////            case "ELIAS":
////                break;
//            default:
//                character = new Character()
//                        .setName("Joana")
//                        .setHint("Sempre Contente!")
//                        .setFace(new Image("/images/lelito.jpg"))
//                        .setWrongFace(new Image("/images/wrongface.jpg"))
//                        .createCharacter();
//        }

        return character;
    }

}
