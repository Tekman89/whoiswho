package org.academiadecodigo.whoiswho.client;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by dmaia on 07-07-2016.
 */
public final class Navigation {

    private final int MIN_WIDTH = 1024;
    private final int MIN_HEIGHT = 768;

    private final String VIEW_PATH = "/view";

    private LinkedList<Scene> scenes = new LinkedList<Scene>();
    private Map<String, Initializable> controllers = new HashMap<>();

    private Stage stage;

    private Initializable controller;

    private static Navigation instance = null;


    private Navigation(){

    }

    public synchronized static Navigation getInstance(){

        if(instance == null){
            instance = new Navigation();
        }

        return instance;
    }

    public void backToLogin(){
        if (scenes.isEmpty()) {
            return;
        }

        // remove the current scene from the stack
        scenes.pop();

        // load the scene at the top of the stack
        setScene(scenes.get(0));
    }

    private void setScene(Scene scene) {

        // set the scene
        stage.setScene(scene);

        // show the stage to reload
        stage.show();
    }


    public void loadScreen(String view) {
        try {

            // Instantiate the view and the controller
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(getClass().getResource(VIEW_PATH + "/" + view + ".fxml"));
            Parent root = fxmlLoader.load();

            //Store the controller
            controllers.put(view, (Initializable) fxmlLoader.getController());

            // Create a new scene and add it to the stack
            Scene scene = new Scene(root, MIN_WIDTH, MIN_HEIGHT);
            scenes.push(scene);

            // Put the scene on the stage
            setScene(scene);

        } catch (IOException e) {
            System.out.println("Failure to load view " + view + " : " + e.getMessage());
        }
    }


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Initializable getController(String view){
        return controllers.get(view);
    }

    public void setController(Initializable controller){
        this.controller = controller;
    }


}
