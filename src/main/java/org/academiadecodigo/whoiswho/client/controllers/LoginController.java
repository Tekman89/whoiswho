package org.academiadecodigo.whoiswho.client.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dmaia on 07-07-2016.
 */
public class LoginController implements Initializable{

    private DataManager manager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField serverField;

    @FXML
    private TextField portField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert usernameField != null : "fx:id=\"usernameField\" was not injected: check your FXML file 'Untitled'.";
        assert serverField != null : "fx:id=\"serverField\" was not injected: check your FXML file 'Untitled'.";
        assert portField != null : "fx:id=\"portField\" was not injected: check your FXML file 'Untitled'.";
    }

    @FXML
    void onConnect(ActionEvent event) {

        manager.setUsername(usernameField.getText());
        manager.setAddress(serverField.getText());
        manager.setPort(portField.getText());

        Navigation.getInstance().loadScreen("startingView");
        Navigation.getInstance().setController(new GameScreenController());
        ((GameScreenController)Navigation.getInstance().getController("startingView")).setManager(manager);
    }

    public void setManager(DataManager manager) {
        this.manager = manager;
    }
}
