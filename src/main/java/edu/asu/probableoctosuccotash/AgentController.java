package edu.asu.probableoctosuccotash;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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
        fillScreen();
    }

    @FXML
    private void fillScreen() {
        for (int i = 0; i < localOrders.size(); i++) {
            localOrders.get(i).details();
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
            detail.setText("ORDER: [" + localOrders.get(i).getType() + "], [" + localOrders.get(i).getToppings() + "]");
            detail.setFont(Font.font("System Bold"));

            processButton.setMnemonicParsing(false);
            processButton.setId("number-button-" + (i));
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
            String rawOrderIndex = buttonId.getId();
            int orderIndex = rawOrderIndex.charAt(rawOrderIndex.length() - 1);
            localOrders.get(orderIndex).updateStatus(100);

        }
    };


    protected void updateScreen(int code) {
        fillScreen();
    }
}
