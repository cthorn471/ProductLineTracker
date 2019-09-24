//make sure to do ANALYZE AND THEN INSPECT CODE to check for my grade before submitting
//file -> settings -> plugins -> download findbugs


package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button btnAddProduct;

    @FXML
    void display(ActionEvent event) {
    System.out.println("hello console");
    }

}
