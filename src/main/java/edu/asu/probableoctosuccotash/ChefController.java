package edu.asu.probableoctosuccotash;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChefController extends OrderManager{
	
	// State: 0 = new order, 100 = Processed, 200 = Cooking, 300 = Cooked, 400 = Killed/Picked Up
	@FXML
	  private VBox Scroll;

	    @Override
	    protected void initialize() {
	        super.initialize();
	    }

	    @FXML
	    private void fillScreen() {
	        Scroll.getChildren().clear();
	        for (int i = 0; i < localOrders.size(); i++) {

	            VBox background = new VBox();
	            Text detail = new Text();
	            Button CookingButton = new Button("Cooking");
	            Button CookedButton = new Button("Cooked");

	            background.setStyle("-fx-background-color: #8b143a;");
	            background.setMaxHeight(1.7976931348623157E308);
	            background.setAlignment(Pos.CENTER);
	            background.setPrefWidth(289.0);
	            background.setSpacing(5.0);

	            detail.setFontSmoothingType(FontSmoothingType.LCD);
	            detail.setStrokeType(StrokeType.OUTSIDE);
	            detail.setStrokeWidth(0.0);
	            
	            
	            if (localOrders.get(i).getState() == 0) {
	            	 detail.setText("ORDER:, ");
	            }
	            else {
	            	
	            detail.setText("ORDER: [" + MainApplication.PizzaTypes.values()[localOrders.get(i).getType()].name() + "], [" + toppingsDecode(localOrders.get(i)) + "]");
	            detail.setFont(Font.font("System Bold"));

	            CookingButton.setMnemonicParsing(false);
	            CookingButton.setId("cooking-button-" + localOrders.get(i).getOrderID());
//	            CookingButton.setOnAction(CookingOrder);
// had a doubt here     
	            CookedButton.setMnemonicParsing(false);
	            CookedButton.setId("cooked-button-" + localOrders.get(i).getOrderID());
//	            CookedButton.setOnAction(CookedOrder);
// had a doubt here
	            
	         
	            if (localOrders.get(i).getState() == 100) {
	                background.setVisible(true);
	                detail.setVisible(true);
	                CookingButton.setVisible(true);
	                CookedButton.setVisible(false);
	                CookingButton.setOnAction(CookingOrder);
	            }else if (localOrders.get(i).getState() == 200) {
	                background.setVisible(true);
	                detail.setVisible(true);
	                CookingButton.setVisible(false);
	                CookedButton.setVisible(true);
	                CookedButton.setOnAction(CookedOrder);
	            }else if (localOrders.get(i).getState() == 300) {
	                background.setVisible(false);
	                detail.setVisible(false);
	                CookingButton.setVisible(false);
	                CookedButton.setVisible(false);
	            }
	            
	            
	            background.getChildren().add(detail);
	            background.getChildren().add(CookingButton);
	            background.getChildren().add(CookedButton);
	            Scroll.getChildren().add(background);

	        }
	       }
	    }

	    public EventHandler<ActionEvent> CookingOrder = new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	            Node buttonId = (Button) actionEvent.getTarget();
	            String[] OrderIndex = buttonId.getId().split("-");
	            int targetID = Integer.parseInt(OrderIndex[OrderIndex.length-1]);
	            localOrders.forEach((c)->{
	               if(c.getOrderID() == targetID) c.updateStatus(200);
	            });
				MainApplication.orderChange.handle(actionEvent);
	        }
	    };
	    
	    public EventHandler<ActionEvent> CookedOrder = new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent actionEvent) {
	            Node buttonId = (Button) actionEvent.getTarget();
	            String[] OrderIndex = buttonId.getId().split("-");
	            int targetID = Integer.parseInt(OrderIndex[OrderIndex.length-1]);
	            localOrders.forEach((c)->{
	               if(c.getOrderID() == targetID) c.updateStatus(300);
	            });
	            MainApplication.orderChange.handle(actionEvent); 
	        }
	    };


	    protected void updateScreen(int code) {
	        fillScreen();
	    }

	    private String toppingsDecode(Order order){
	        String r = "";
	        int top = order.getToppings();
	        if(top - 8 >= 0){
	            r+= "X-Cheese ";
	            top-=8;
	        }
	        if(top - 4 >= 0){
	            r+= "Olives ";
	            top-=4;
	        }
	        if(top - 2 >= 0){
	            r+= "Mushrooms ";
	            top-=2;
	        }
	        if(top - 1 >= 0){
	            r+= "Onion ";
	            top-=1;
	        }
	        if(r.length() == 0) return "No Toppings";
	        else return r.substring(0, r.length()-1);
	    }
	}

	
