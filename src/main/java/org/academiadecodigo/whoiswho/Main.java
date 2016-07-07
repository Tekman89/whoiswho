package org.academiadecodigo.whoiswho;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.whoiswho.client.Navigation;

/**
 * Created by codecadet on 07/07/16.
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("loginView");



    }


}
