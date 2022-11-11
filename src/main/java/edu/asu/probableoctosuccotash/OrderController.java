package edu.asu.probableoctosuccotash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

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

    @FXML
    private void initialize(){
        pizzaType.setItems(pizzaTypeList);
        errorMsg.setVisible(false);
    }
    @FXML
    private void submitOrder(){
        String type;
        type = (String)pizzaType.getValue();
        if(type == null) {
            errorMsg.setVisible(true);
            return;
        }
        errorMsg.setVisible(false);
        int toppings = 0;
        if(xcheeseBox.isSelected()) toppings+=8;
        if(olivesBox.isSelected()) toppings+=4;
        if(mushBox.isSelected()) toppings+=2;
        if(onionBox.isSelected()) toppings+=1;
        //For Testing purposes only, will create order and then open the Tracking View
        System.out.println("Toppings: " + toppings+" PizzaType: "+ MainApplication.PizzaTypes.valueOf(type.toUpperCase()).getValue());
    }

    protected void updateScreen(int code) {
        ////Code 0: Show error

        ////Code 1:
        //Open Tracking View
        //Set Active order ID on tracking view
        //Close Order window

        if(code == 10) return;
    }
    public void setUserID(int id){userID = id;}
}
