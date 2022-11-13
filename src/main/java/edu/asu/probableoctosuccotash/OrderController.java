package edu.asu.probableoctosuccotash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderController extends OrderManager{

    @FXML
    private ChoiceBox pizzaType;
    @FXML
    private Button submitButton;
    @FXML
    private Label errorMsg;
    @FXML
    private CheckBox xcheeseBox;
    @FXML
    private CheckBox olivesBox;
    @FXML
    private CheckBox mushBox;
    @FXML
    private CheckBox onionBox;

    private int userID;

    ObservableList<String> pizzaTypeList = FXCollections.observableArrayList("Pepperoni","Veggie", "Cheese");

    protected void initialize(){
        super.initialize();
        pizzaType.setItems(pizzaTypeList);
        errorMsg.setVisible(false);
        submitButton.setOnAction(submitOrder);
    }

    private EventHandler<ActionEvent> submitOrder = event -> {
        String type;
        type = (String)pizzaType.getValue();
        int pType = 0;
        if(type == null) {
            errorMsg.setVisible(true);
            return;
        }else {
            for (int i = 0; i < pizzaTypeList.size(); i++) {
                String s = pizzaTypeList.get(i);
                if(s.equals(type)) {
                    pType = i;
                }
            }
        }
        errorMsg.setVisible(false);
        int toppings = 0;
        if(xcheeseBox.isSelected()) toppings+=8;
        if(olivesBox.isSelected()) toppings+=4;
        if(mushBox.isSelected()) toppings+=2;
        if(onionBox.isSelected()) toppings+=1;
        int newOrderID = MainApplication.createOrder(toppings, pType, this.userID); //Dev Code, remove later
        MainApplication.orderChange.handle(event);
        try {
            FXMLLoader fLoader= new FXMLLoader(MainApplication.class.getResource("tracking-view.fxml"));
            Scene s = new Scene(fLoader.load(), 600,400);
            Stage n = new Stage();
            n.setScene(s);
            n.show();
            TrackingController c = fLoader.getController();
            c.setOrderID(newOrderID);
            MainApplication.pushController(c);
            ((Node)event.getSource()).getScene().getWindow().hide();
        }catch(IOException e) {
            e.printStackTrace();
        }
    };

    protected void updateScreen(int code) {return; /*Screen Does not need to update*/}
    public void setUserID(int id){userID = id;}
}
