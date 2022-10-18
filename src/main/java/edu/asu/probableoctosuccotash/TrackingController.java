package edu.asu.probableoctosuccotash;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class TrackingController {
    private static Color gold = Color.rgb(249,201,52);
    private static Color grey = Color.rgb(148,148,148);
    private static Color green = Color.rgb(111,228,53);

    @FXML
    private Label accept;
    @FXML
    private Label readyCook;
    @FXML
    private Label cooking;
    @FXML
    private Label readyPickup;

    private int state;
    private String last;

    @FXML
    public void initialize(){
        accept.setTextFill(grey);
        readyCook.setTextFill(grey);
        readyPickup.setTextFill(grey);
        cooking.setTextFill(grey);
        state = 0;
    }

    public void setAcceptOrder(){
        if(state != 0) return;
        accept.setTextFill(green);
        this.append(accept);
        readyCook.setTextFill(grey);
        cooking.setTextFill(grey);
        readyPickup.setTextFill(grey);
        state++;
    }
    public void setReadyCook(){
        if(state != 1) return;
        accept.setTextFill(gold);
        accept.setText(last);
        readyCook.setTextFill(green);
        this.append(readyCook);
        cooking.setTextFill(grey);
        readyPickup.setTextFill(grey);
        state++;
    }
    public void setCooking(){
        if(state != 2) return;
        accept.setTextFill(gold);
        readyCook.setTextFill(gold);
        readyCook.setText(last);
        cooking.setTextFill(green);
        this.append(cooking);
        readyPickup.setTextFill(grey);
        state++;
    }
    public void setReadyPickup(){
        if(state != 3) return;
        accept.setTextFill(gold);
        readyCook.setTextFill(gold);
        cooking.setTextFill(gold);
        cooking.setText(last);
        readyPickup.setTextFill(green);
        this.append(readyPickup);
        state++;
    }
    private void append(Label l){
        last = l.getText();
        l.setText(last+"  <");
    }
    @FXML
    private void testClick(){
        switch(state){
            case 0:
                setAcceptOrder();
                break;
            case 1:
                setReadyCook();
                break;
            case 2:
                setCooking();
                break;
            case 3:
                setReadyPickup();
                state = 0;
                break;
        }
    }
}
