package edu.asu.probableoctosuccotash;

import java.util.ArrayList;

public abstract class OrderManager {
    protected static ArrayList<Order> localOrders;
    protected void submitOrder(int toppings, int type, int userID){
        updateScreen(MainApplication.createOrder(toppings, type, userID));
    }
    abstract protected void updateScreen(int code);
    public void statusChange(){
        localOrders = MainApplication.fetchOrders();
        updateScreen(0);
    }
}
