package edu.asu.probableoctosuccotash;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    private static int depth;
    private static ArrayList<Order> orders;
    private static ArrayList<? super OrderManager> controllers;

    public enum PizzaTypes{
        PEPPERONI(0), VEGGIE(1), CHEESE(2);
        private int value;
        PizzaTypes(int value){ this.value = value; }
        public int getValue(){return this.value;}
        //public String getName(){return name();}
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dev-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("SunDevil Pizza");
        stage.setScene(scene);
        stage.show();

        depth = 0;
        orders = new ArrayList<Order>();
        controllers = new ArrayList<>();
    }

    public static void main(String[] args) {
        launch();
    }
    public static int getDepth(){return ++depth;}
    public static int createOrder(int toppings, int type, int userID){ //may need to add event callback into method, could use a promise
        Order newOrder = new Order(toppings, type, userID);
        orders.add(newOrder);
        return newOrder.getOrderID();
    }
    public static ArrayList<Order> fetchOrders(){return orders;}
    public static void pushController(OrderManager c){controllers.add(c);}

    public static EventHandler<ActionEvent> orderChange = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            controllers.forEach((c) -> {
                //this code is disgusting please clean it if you can
                //if(c instanceof OrderController) ((OrderController) c).statusChange();
                if(c instanceof AgentController) ((AgentController) c).statusChange();
                if(c instanceof ChefController) ((ChefController) c).statusChange();
                if(c instanceof TrackingController) ((TrackingController) c).statusChange();
            });
        }
    };
}