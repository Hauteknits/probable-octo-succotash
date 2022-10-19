//Made by Holden Clarke, resident spaghetti coder

package edu.asu.probableoctosuccotash;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DevController {
    private String resource = "";

    @FXML
    private Button login;
    @FXML
    private Button order;
    @FXML
    private Button chef;
    @FXML
    private Button tracking;
    @FXML
    private Button agent;

    @FXML
    private void launchLogin(){
        resource = "hello-view.fxml";
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void launchOrder(){
        resource = "order-view.fxml";
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void launchChef(){
        resource = "chef-view.fxml";
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void launchTracking(){
        resource = "tracking-view.fxml";
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void launchAgent(){
        resource = "agent-view.fxml";
        try {
            open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void open() throws IOException {
        FXMLLoader fLoader= new FXMLLoader(HelloApplication.class.getResource(resource));
        Scene s = new Scene(fLoader.load(), 600,400);
        Stage n = new Stage();
        n.setScene(s);
        n.show();
    }
}
