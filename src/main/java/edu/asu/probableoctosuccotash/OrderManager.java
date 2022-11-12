package edu.asu.probableoctosuccotash;

import javafx.fxml.FXML;

import java.util.ArrayList;

public abstract class OrderManager {
    protected static ArrayList<Order> localOrders;

    abstract protected void updateScreen(int code);

    public void statusChange(){
        localOrders = MainApplication.fetchOrders();
        updateScreen(10);
    }
    @FXML
    protected void initialize(){
        this.statusChange();
    }
}
