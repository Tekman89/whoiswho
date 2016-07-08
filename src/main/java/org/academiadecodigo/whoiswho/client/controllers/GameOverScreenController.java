package org.academiadecodigo.whoiswho.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.academiadecodigo.whoiswho.client.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dmaia on 07-07-2016.
 */
public class GameOverScreenController implements Initializable {

    private String itsOver;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label gameOverLabel;

    @FXML
    void onExit(ActionEvent event) {
        closeWindow(event);
        System.exit(0);
    }

    @FXML
    void onPlayAgain(ActionEvent event) {
        closeWindow(event);
        Navigation.getInstance().backToLogin();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert gameOverLabel != null : "fx:id=\"gameOverLabel\" was not injected: check your FXML file 'gameOverView.fxml'.";
    }

    public void closeWindow(ActionEvent event){
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    public void setItsOver(String itsOver) {
        this.itsOver = itsOver;
    }

    public void start() {
        gameOverLabel.setText(itsOver);
    }
}
