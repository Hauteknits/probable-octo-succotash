package edu.asu.probableoctosuccotash;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.Text;


public class AgentController extends OrderManager{

    @FXML
    private VBox mainScroll;

    @Override
    protected void initialize() {
        super.initialize();
    }

    @FXML
    private void fillScreen() {
        mainScroll.getChildren().clear();
        for (int i = 0; i < localOrders.size(); i++) {

            VBox background = new VBox();
            Text detail = new Text();
            Button processButton = new Button("Ready to Cook");

            background.setStyle("-fx-background-color: #8b143a;");
            background.setMaxHeight(1.7976931348623157E308);
            background.setAlignment(Pos.CENTER);
            background.setPrefWidth(289.0);
            background.setSpacing(5.0);

            detail.setFontSmoothingType(FontSmoothingType.LCD);
            detail.setStrokeType(StrokeType.OUTSIDE);
            detail.setStrokeWidth(0.0);
            detail.setText("ORDER: [" + MainApplication.PizzaTypes.values()[localOrders.get(i).getType()].name() + "], [" + toppingsDecode(localOrders.get(i)) + "]");
            detail.setFont(Font.font("System Bold"));

            processButton.setMnemonicParsing(false);
            processButton.setId("number-button-" + localOrders.get(i).getOrderID());
            processButton.setOnAction(processOrder);

            if (localOrders.get(i).getState() != 0) {
                background.setVisible(false);
                detail.setVisible(false);
                processButton.setVisible(false);

            }
            background.getChildren().add(detail);
            background.getChildren().add(processButton);
            mainScroll.getChildren().add(background);

        }
    }

    public EventHandler<ActionEvent> processOrder = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Node buttonId = (Button) actionEvent.getTarget();
            String[] rawOrderIndex = buttonId.getId().split("-");
            int targetID = Integer.parseInt(rawOrderIndex[rawOrderIndex.length-1]);
            localOrders.forEach((c)->{
               if(c.getOrderID() == targetID) c.updateStatus(100);
            });
            MainApplication.orderChange.handle(actionEvent); //Calls main screen update method
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
