package edu.asu.probableoctosuccotash;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ChefController extends OrderManager{
	
	// State: 0 = new order, 100 = Processed, 200 = Cooking, 300 = Cooked, 400 = Killed/Picked Up
	
	private int orderID;
	
	@FXML
    private Button cookedButton;

	 public EventHandler<ActionEvent> Cooked = new EventHandler<ActionEvent>() {
	@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				for(Order order : localOrders) {
		    		if(orderID == order.getOrderID()) {
		    			if(order.getState() == 200) {
		    				order.updateStatus(300);
		    			}
		    		}
				}
				
			}

			
	 };
	        
	        private void updatestatus() {
	        	 cookedButton.setOnAction(Cooked);
	        }
	 
   

	@Override
	protected void updateScreen(int code) {
		// TODO Auto-generated method stub
		for(Order order : localOrders) {
    		if(orderID == order.getOrderID()) {
    			if(order.getState() == 200) {
    				order.updateStatus(300);
    			}
    		}
    		}
	}}

    

    	
    
    

    

	