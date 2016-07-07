package org.academiadecodigo.whoiswho.client;

import javafx.scene.image.Image;

/**
 * Created by dmaia on 07-07-2016.
 */
public class Character {

    private String name;
    private String hint;
    private Image face;
    private Image wrongFace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Image getFace() {
        return face;
    }

    public void setFace(Image face) {
        this.face = face;
    }

    public Image getWrongFace() {
        return wrongFace;
    }

    public void setWrongFace(Image wrongFace) {
        this.wrongFace = wrongFace;
    }
}
