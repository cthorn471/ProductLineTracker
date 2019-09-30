//make sure to do ANALYZE AND THEN INSPECT CODE to check for my grade before submitting
//file -> settings -> plugins -> download findbugs
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * @author Christopher Thorn
 *The controller class holds all the values from the objects being used in the GUI.
 * 9/28/2019
 */
public class Controller {

  @FXML
  private TextField TextFieldProductName;

  @FXML
  private TextField TextFieldManufacturer;

  @FXML
  private ChoiceBox<?> ChoiceBoxItemType;

  @FXML
  private Button btnAddProduct;

  @FXML
  private Label TestLabel;

  @FXML
  private ComboBox<String> ComboBoxChooseQuantity;

  @FXML
  private Button btnRecordProduction;

  /**
   * The display method executes a button click mouse event when the "Add Product" button on the
   * Product Line tab is pushed. Once the button is pushed all information in Product Name and
   * Manufacturer Text fields is saved.
   * mouseEvent displays under Analyze code as a warning however it is needed to run the button
   * click action.
   * @param mouseEvent allows the button click action to occur.
   */
  public void display(javafx.scene.input.MouseEvent mouseEvent) {

    String SQLStatement = "INSERT INTO Product(type, manufacturer, name) VALUES ('AUDIO', "
        + "'"
        + TextFieldManufacturer.getText()
        + "', '"
        + TextFieldProductName.getText()
        + "')";

    //System.out.print(SQLStatement);
    //pass the sql statement from SQLStatement to  the method sqlExecute in Main.
    Main.sqlExecute(SQLStatement);
  }

  /**
   * The initialize method creates the numbered list for the comboBox from 1-10 and allows the user
   * the make a selection and edit previous selections.
   */
  @FXML
  private void initialize() {
    ComboBoxChooseQuantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9",
        "10");
    ComboBoxChooseQuantity.getSelectionModel().selectFirst();
    ComboBoxChooseQuantity.setEditable(true);

  }
}

