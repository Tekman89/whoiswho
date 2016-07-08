package org.academiadecodigo.whoiswho;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;
import org.academiadecodigo.whoiswho.client.controllers.LoginController;
import org.academiadecodigo.whoiswho.server.Server;

import java.io.IOException;

/**
 * Created by codecadet on 08/07/16.
 */
public class Main extends Application{

    public static void main(String[] args) {

        int port;
        int games;

        if (args.length == 3 && args[0].equalsIgnoreCase("server")) {
            if ((port = Integer.parseInt(args[1])) <= 1024) {
                System.out.println("Invalid Port. Allocated Port: 8080");
                port = 8080;
            }
            if ((games = Integer.parseInt(args[2])) > 3) {
                System.out.println("Can only support up to 3 games. GamesSet: 3");
                games = 3;
            }
            try {
                Server server = new Server(port, games);
                server.host();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (args.length == 1 && args[0].equalsIgnoreCase("client")) {
            launch(args);
        } else {
            System.out.println("You have to specify if you want to run a Server or a Client" + "\n" +
                    "If you want to run a Server just write the port (default:8080) and number of games" + "\n"
                    + "If you want to run a Client just write \"client\"");

        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation.getInstance().setStage(primaryStage);
        Navigation.getInstance().loadScreen("loginView");

        DataManager manager = new DataManager();
        ((LoginController) Navigation.getInstance().getController("loginView")).setManager(manager);
    }
}
