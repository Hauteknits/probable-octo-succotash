package edu.asu.probableoctosuccotash;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class TrackingController extends OrderManager{
    private static Color gold = Color.rgb(249,201,52);
    private static Color grey = Color.rgb(148,148,148);
    private static Color green = Color.rgb(111,228,53);
    
    private String last = "Order Accepted";
	private int lastState = 0;

    private int orderID;
    @FXML
    private Label accept;
    @FXML
    private Label readyCook;
    @FXML
    private Label cooking;
    @FXML
    private Label readyPickup;

    // State: 0 = new order, 100 = Processed, 200 = Cooking, 300 = Cooked, 400 = Killed/Picked Up
    @Override
    protected void updateScreen(int code) {
    	localOrders.forEach((order) -> {
    		if(orderID == order.getOrderID()) {
				if(lastState == order.getState()) return;
    			if(order.getState() == 100) {
    				accept.setTextFill(gold);
    		        accept.setText(last);
    		        readyCook.setTextFill(green);
    		        this.append(readyCook);
    		        cooking.setTextFill(grey);
    		        readyPickup.setTextFill(grey);
    		        
    			}else if(order.getState() == 200) {
    				accept.setTextFill(gold);
    		        readyCook.setTextFill(gold);
    		        readyCook.setText(last);
    		        cooking.setTextFill(green);
    		        this.append(cooking);
    		        readyPickup.setTextFill(grey);
    		        
    			}else if(order.getState() == 300) {
    				accept.setTextFill(gold);
    		        readyCook.setTextFill(gold);
    		        cooking.setTextFill(gold);
    		        cooking.setText(last);
    		        readyPickup.setTextFill(green);
    		        this.append(readyPickup);
    			}
				lastState = order.getState();
    		}
    	});
    }

    public void setOrderID(int orderID) {this.orderID = orderID;}
    
    private void append(Label l){
        last = l.getText();
        l.setText(last+"  <");
    }

//    Test Code
//    private int state;
    
//
//    @FXML
//    public void initialize(){
//        accept.setTextFill(grey);
//        readyCook.setTextFill(grey);
//        readyPickup.setTextFill(grey);
//        cooking.setTextFill(grey);
//        state = 0;
//    }
//
//    public void setAcceptOrder(){
//        if(state != 0) return;
//        accept.setTextFill(green);
//        this.append(accept);
//        readyCook.setTextFill(grey);
//        cooking.setTextFill(grey);
//        readyPickup.setTextFill(grey);
//        state++;
//    }
//    public void setReadyCook(){
//        if(state != 1) return;
//        accept.setTextFill(gold);
//        accept.setText(last);
//        readyCook.setTextFill(green);
//        this.append(readyCook);
//        cooking.setTextFill(grey);
//        readyPickup.setTextFill(grey);
//        state++;
//    }
//    public void setCooking(){
//        if(state != 2) return;
//        accept.setTextFill(gold);
//        readyCook.setTextFill(gold);
//        readyCook.setText(last);
//        cooking.setTextFill(green);
//        this.append(cooking);
//        readyPickup.setTextFill(grey);
//        state++;
//    }
//    public void setReadyPickup(){
//        if(state != 3) return;
//        accept.setTextFill(gold);
//        readyCook.setTextFill(gold);
//        cooking.setTextFill(gold);
//        cooking.setText(last);
//        readyPickup.setTextFill(green);
//        this.append(readyPickup);
//        state++;
//    }
//    @FXML
//    private void testClick(){
//        switch(state){
//            case 0:
//                setAcceptOrder();
//                break;
//            case 1:
//                setReadyCook();
//                break;
//            case 2:
//                setCooking();
//                break;
//            case 3:
//                setReadyPickup();
//                state = 0;
//                break;
//        }
//    }


}
