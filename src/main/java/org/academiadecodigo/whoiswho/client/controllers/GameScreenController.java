package org.academiadecodigo.whoiswho.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dmaia on 07-07-2016.
 */
public class GameScreenController implements Initializable{

    private ImageView[] imageViews;
    private DataManager manager;

    @FXML
    private GridPane gridPane;
/*
    @FXML
    private ImageView image00;

    @FXML
    private ImageView image01;

    @FXML
    private ImageView image02;

    @FXML
    private ImageView image03;

    @FXML
    private ImageView image04;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image13;

    @FXML
    private ImageView image14;

    @FXML
    private ImageView image20;

    @FXML
    private ImageView image21;

    @FXML
    private ImageView image22;

    @FXML
    private ImageView image23;

    @FXML
    private ImageView image24;

    @FXML
    private ImageView image30;

    @FXML
    private ImageView image31;

    @FXML
    private ImageView image32;

    @FXML
    private ImageView image33;

    @FXML
    private ImageView image34;*/
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField answerField;

    @FXML
    private Label hintLabel;

    @FXML
    private ImageView playerCharacter;

    @FXML
    private TextArea chatArea;

    @FXML
    private TextField hintChat;

    @FXML
    void onAnswer(ActionEvent event) {
        manager.getClient().sendToServer("@" + answerField.getText().replaceAll("@", ""));
    }


    @FXML
    void onChatEnter(KeyEvent event) {

        if (event.getCode().equals(KeyCode.ENTER)) {
            manager.getClient().sendToServer(hintChat.getText());
            hintChat.clear();
        }
    }

    @FXML
    void onImageClick(MouseEvent event) {

        Node source = (Node)event.getSource();

        for (int i = 0; i < imageViews.length; i++) {

            if (!manager.getCharacters()[i].isFaceDown()) {
                if (source.getId().equals(imageViews[i].getId())) {
                    imageViews[i].setImage(manager.getCharacters()[i].getWrongFace());
                    manager.getCharacters()[i].setFaceDown(true);

                }
            } else {
                if (source.getId().equals(imageViews[i].getId())) {
                    imageViews[i].setImage(manager.getCharacters()[i].getFace());
                    manager.getCharacters()[i].setFaceDown(false);

                }
            }

        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert answerField != null : "fx:id=\"answerField\" was not injected: check your FXML file 'gameView.fxml'.";
        assert hintLabel != null : "fx:id=\"hintLabel\" was not injected: check your FXML file 'gameView.fxml'.";

    }

    public void start(){
        setImageDisplay();

        for (ImageView view: imageViews) {
            System.out.println(view);
        }

        populateImages();
        playerCharacter.setImage(manager.getSelected().getFace());
    }

    public void setImageDisplay() {

        imageViews = new ImageView[1];

        for (Node node: gridPane.getChildren()) {
            int i = imageViews.length-1;

            if (i < 0) {
                return;
            }
            if (node instanceof  ImageView) {
                imageViews[i] = (ImageView) node;
                i--;
            }
        }

      /*  imageViews[0] = image00;
        imageViews[1] = image01;
        imageViews[2] = image02;
        imageViews[3] = image03;
        imageViews[4] = image04;
        imageViews[5] = image10;
        imageViews[6] = image11;
        imageViews[7] = image12;
        imageViews[8] = image13;
        imageViews[9] = image14;
        imageViews[10] = image20;
        imageViews[11] = image21;
        imageViews[12] = image22;
        imageViews[13] = image23;
        imageViews[14] = image24;
        imageViews[15] = image30;
        imageViews[16] = image31;
        imageViews[17] = image32;
        imageViews[18] = image33;
        imageViews[19] = image34;*/

    }

    public void setManager(DataManager manager) {
        this.manager = manager;
    }

    public void populateImages() {
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].
                    setImage(
                            manager.getCharacters()[i].getFace());
        }
    }

    public void update(String answer){

        String temp = "";

        if (answer.equals(" ")) {
            temp = "You Won";

        } else {
            temp = "You Lost";
        }

        Navigation.getInstance().loadScreen("gameOverView");
        Navigation.getInstance().setController(new GameOverScreenController());
        ((GameOverScreenController)Navigation.getInstance().getController("gameOverView")).setItsOver(temp);
        ((GameOverScreenController)Navigation.getInstance().getController("gameOverView")).start();
        System.out.println(Navigation.getInstance().getController("gameOverView"));

    }

    public TextArea getChatArea() {
        return chatArea;
    }
}
