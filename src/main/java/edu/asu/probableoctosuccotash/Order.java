package edu.asu.probableoctosuccotash;

public class Order {
    /*
        Toppings stored in integer as 0bABCD
        A- Cheese
        B- Olives
        C- Mushrooms
        D- Onion

        State: 0 = new order, 100 = Processed, 200 = Cooking, 300 = Cooked, 400 = Killed/Picked Up
     */
    private int toppings;
    private int type;
    private int orderID;
    private int userID;
    private int state;

    public Order(int toppings, int type, int userID){
        this.toppings = toppings;
        this.type = type;
        this.userID = userID;
        this.orderID = MainApplication.getDepth();
        state = 0;
    }

    public int getToppings() {return toppings;}
    public int getType() {return type;}
    public int getOrderID() {return orderID;}
    public int getUserID() {return userID;}
    public int getState() {return state;}

    public void updateStatus(int state){this.state = state;}
}
