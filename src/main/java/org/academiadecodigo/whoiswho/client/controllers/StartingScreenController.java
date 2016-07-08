package org.academiadecodigo.whoiswho.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;
import org.academiadecodigo.whoiswho.utilities.Sound;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dmaia on 07-07-2016.
 */
public class StartingScreenController implements Initializable{


    private ImageView[] imageViews;
    private DataManager manager;
    private String path = "src/main/resources/" ;

    @FXML
    private GridPane gridPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void onImageClick(MouseEvent event) {

        Node source = (Node)event.getSource();

        if(imageViews == null){
            return;
        }

        System.out.println(imageViews);

        for (int i = 0; i < imageViews.length; i++) {

            if (source.getId().equals(imageViews[i].getId())) {
                manager.setSelected(manager.getCharacters()[i]);
                manager.getClient().sendToServer(manager.getSelected().getName());
                Sound.play(path + "sound/" + manager.getSelected().getName().toLowerCase() + ".wav");
                Navigation.getInstance().loadScreen("gameView");
                Navigation.getInstance().setController(new GameScreenController());
                ((GameScreenController)Navigation.getInstance().getController("gameView")).setManager(manager);
                manager.setObserver((GameScreenController) Navigation.getInstance().getController("gameView"));
                ((GameScreenController)Navigation.getInstance().getController("gameView")).start();
            }

        }

    }

    public void start(){
        setImageDisplay();
        populateImages();
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

    public void populateImages() {
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImage(manager.getCharacters()[i].getFace());
        }
    }

    public void setManager(DataManager manager) {
        this.manager = manager;
    }

    public DataManager getManager() {
        return manager;
    }
}
