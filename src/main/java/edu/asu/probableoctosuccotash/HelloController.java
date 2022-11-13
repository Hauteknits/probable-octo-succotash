package edu.asu.probableoctosuccotash;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    private String resource = "";

    @FXML
    private TextField idField;
    @FXML
    private Label errorMsg;
    @FXML
    private Button submitButton;

    public EventHandler<ActionEvent> processLogin = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            int id = -1;
            try {
                id = Integer.parseInt(idField.getText());
            }catch(NumberFormatException ex) {
                errorMsg.setVisible(true);
                return;
            }
            if((int)Math.log10(id)+1 != idField.getText().length()){errorMsg.setVisible(true);return;} //covers leading 0s

            if(id/Math.pow(10,9) >= 1) resource = "order-view.fxml";
            else if(id == 12345) resource = "chef-view.fxml";
            else if(id == 42069) resource = "agent-view.fxml";
            else {errorMsg.setVisible(true); return;}

            try{MainApplication.pushController(open(id));}
            catch(IOException ex){ex.printStackTrace();}

            //Closes window, uncomment in prod build
            //((Node)e.getSource()).getScene().getWindow().hide();

        }
    };

    @FXML
    private void initialize(){
        errorMsg.setVisible(false);
        submitButton.setOnAction(processLogin);
    }
    private OrderManager open(int id) throws IOException {
        FXMLLoader fLoader= new FXMLLoader(MainApplication.class.getResource(resource));
        Scene s = new Scene(fLoader.load(), 600,400);
        Stage n = new Stage();
        n.setScene(s);
        n.show();
        if(resource.equals("order-view.fxml")){
            OrderController c = fLoader.getController();
            c.setUserID(id);
        }
        return fLoader.getController();
    }
}