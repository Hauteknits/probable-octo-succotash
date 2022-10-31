package edu.asu.probableoctosuccotash;

public class Order {
    /*
        Toppings stored in integer as 0bABCD
        A- Cheese
        B- Olives
        C- Mushrooms
        D- Onion

        State: 0 = new order, 100 = Processed, 200 = Cooked, 300 = Killed
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
        this.orderID = HelloApplication.getDepth();
        state = 0;
    }
    public void updateStatus(int state){
        this.state = state;
    }
    public String details(){
        return null; //placeholder for getting text/info about pizza
    }
}
