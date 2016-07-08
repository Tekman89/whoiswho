package org.academiadecodigo.whoiswho.tests;

import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;
import org.academiadecodigo.whoiswho.client.controllers.LoginController;

import org.academiadecodigo.whoiswho.server.Server;

import java.io.IOException;

/**
 * Created by codecadet on 07/07/16.
 */
public class MainGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("loginView");

        DataManager manager = new DataManager();
        ((LoginController) Navigation.getInstance().getController("loginView")).setManager(manager);

    }

}
