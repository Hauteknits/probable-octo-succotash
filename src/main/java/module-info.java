module edu.asu.probableoctosuccotash {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;


    opens edu.asu.probableoctosuccotash to javafx.fxml;
    exports edu.asu.probableoctosuccotash;
}