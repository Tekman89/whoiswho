package org.academiadecodigo.whoiswho.client.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import org.academiadecodigo.whoiswho.client.DataManager;
import org.academiadecodigo.whoiswho.client.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by dmaia on 07-07-2016.
 */
public class StartingScreenController implements Initializable{


    private ImageView[] imageViews;
    private DataManager manager;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private ImageView image34;

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
                Navigation.getInstance().loadScreen("gameView");
                Navigation.getInstance().setController(new GameScreenController());
                ((GameScreenController)Navigation.getInstance().getController("gameView")).setManager(manager);
                manager.setObserver((GameScreenController) Navigation.getInstance().getController("gameView"));
                ((GameScreenController)Navigation.getInstance().getController("gameView")).start();
            }

        }
        System.out.println("Image Clicked");

    }

    public void start(){
        System.out.println("Initialize the start");
        setImageDisplay();
        populateImages();
    }

    public void setImageDisplay() {

        imageViews = new ImageView[1];

        imageViews[0] = image00;
//        imageViews[1] = image01;
//        imageViews[2] = image02;
//        imageViews[3] = image03;
//        imageViews[4] = image04;
//        imageViews[5] = image10;
//        imageViews[6] = image11;
//        imageViews[7] = image12;
//        imageViews[8] = image13;
//        imageViews[9] = image14;
//        imageViews[10] = image20;
//        imageViews[11] = image21;
//        imageViews[12] = image22;
//        imageViews[13] = image23;
//        imageViews[14] = image24;
//        imageViews[15] = image30;
//        imageViews[16] = image31;
//        imageViews[17] = image32;
//        imageViews[18] = image33;
//        imageViews[19] = image34;

    }

    public void populateImages() {
        System.out.println(imageViews);
        System.out.println("Manager" + manager);
        System.out.println("Characters: " + manager.getCharacters()[0]);
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
