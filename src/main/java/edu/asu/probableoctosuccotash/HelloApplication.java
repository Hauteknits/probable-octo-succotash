package edu.asu.probableoctosuccotash;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static int depth;
    private static ArrayList<Order> orders;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("dev-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("SunDevil Pizza");
        stage.setScene(scene);
        stage.show();

        depth = 0;
        orders = new ArrayList<Order>();
    }

    public static void main(String[] args) {
        launch();
    }
    public static int getDepth(){return ++depth;}
    public static void createOrder(int toppings, int type, int userID){ //may need to add event callback into method, could use a promise
        Order newOrder = new Order(toppings, type, userID);
        orders.add(newOrder);
        //fire event back to calling class
    }
}