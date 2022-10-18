package edu.asu.probableoctosuccotash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class OrderController {
    @FXML
    private ChoiceBox pizzaType;

    ObservableList<String> pizzaTypeList = FXCollections.observableArrayList("Pepperoni","Veggie", "Cheese");

    @FXML
    private void initialize(){
        pizzaType.setItems(pizzaTypeList);
    }
}
