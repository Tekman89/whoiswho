package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;

/**
 * Created by dmaia on 07-07-2016.
 */
public class Character {

    private String name;
    private String hint;
    private boolean faceDown;
    private Image face;
    private Image wrongFace;

    public Character(String name, String hint, Image face, Image wrongFace) {
        this.name = name;
        this.hint = hint;
        this.face = face;
        this.wrongFace = wrongFace;
    }

    public Character() {
    }

    public String getName() {
        return name;
    }

    public Character setName(String name) {
        this.name = name;
        return this;
    }

    public String getHint() {
        return hint;
    }

    public Character setHint(String hint) {
        this.hint = hint;
        return this;
    }

    public Image getFace() {
        return face;
    }

    public Character setFace(Image face) {
        this.face = face;
        return this;
    }

    public Image getWrongFace() {
        return wrongFace;
    }

    public Character setWrongFace(Image wrongFace) {
        this.wrongFace = wrongFace;
        return this;
    }

    public Character createCharacter() {
        return new Character(name, hint, face, wrongFace);
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public void setFaceDown(boolean faceDown) {
        this.faceDown = faceDown;
    }
}