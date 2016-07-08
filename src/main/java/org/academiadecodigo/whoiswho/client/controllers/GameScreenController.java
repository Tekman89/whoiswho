package org.academiadecodigo.whoiswho.client.controllers;

import com.oracle.javafx.jmx.json.JSONReader;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
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
    private Button retryButton;

    @FXML
    private Button exitButton;

    @FXML
    void onAnswer(ActionEvent event) {
        manager.getClient().sendToServer("@" + answerField.getText().replaceAll("@", ""));

    }

    @FXML
    void onRetry(ActionEvent event) {
        closeWindow(event);
        Navigation.getInstance().backToLogin();
    }

    @FXML
    void onExit(ActionEvent event) {
        closeWindow(event);
        System.exit(0);
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
        System.out.println("catched");

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

        retryButton.setDisable(true);
        retryButton.setVisible(false);
        exitButton.setDisable(true);
        exitButton.setVisible(false);

    }

    public void start(){
        setImageDisplay();

        populateImages();
        playerCharacter.setImage(manager.getSelected().getFace());
    }

    public void setImageDisplay() {

        imageViews = new ImageView[20];

        int i = imageViews.length - 1;
        for (Node node: gridPane.getChildren()) {

            if (i < 0) {
                return;
            }
            if (node instanceof  ImageView) {
                imageViews[i] = (ImageView) node;
                i--;
            }
        }

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

        System.out.println(answer);
        System.out.println(manager.getUsername());
        if (answer.contains(manager.getUsername())) {
            temp = "You Won";

        } else {
            temp = "You Lost";
        }

        synchronized (manager.getClient()) {

            /*Navigation.getInstance().loadScreen("gameOverView");
            Navigation.getInstance().setController(new GameOverScreenController());
            ((GameOverScreenController) Navigation.getInstance().getController("gameOverView")).setItsOver(temp);
            ((GameOverScreenController) Navigation.getInstance().getController("gameOverView")).start();
            System.out.println(Navigation.getInstance().getController("gameOverView"));*/

            retryButton.setDisable(false);
            retryButton.setVisible(true);
            exitButton.setDisable(false);
            exitButton.setVisible(true);

        }

    }

    public void closeWindow(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    public TextArea getChatArea() {
        return chatArea;
    }
}
