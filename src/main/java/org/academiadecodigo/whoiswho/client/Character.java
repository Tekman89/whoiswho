package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;

/**
 * Created by dmaia on 07-07-2016.
 */
public class Character {

    private String name;
    private boolean faceDown;
    private Image face;
    private Image wrongFace;

    public Character(String name, Image face, Image wrongFace) {
        this.name = name;
        this.face = face;
        this.wrongFace = wrongFace;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setFaceDown(boolean faceDown) {
            this.faceDown = faceDown;
    }


    public Image getFace() {
        return face;
    }


    public Image getWrongFace() {
        return wrongFace;
    }


    public boolean isFaceDown() {
        return faceDown;
    }

    public static class CharacterBuilder {
        private String name;
        private Image face;
        private Image wrongFace;

        public CharacterBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CharacterBuilder setFace(Image face) {
            this.face = face;
            return this;
        }

        public CharacterBuilder setWrongFace(Image wrongFace) {
            this.wrongFace = wrongFace;
            return this;
        }

        public Character createCharacter() {
            return new Character(name, face, wrongFace);
        }

    }

}
