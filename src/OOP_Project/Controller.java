//make sure to do ANALYZE AND THEN INSPECT CODE to check for my grade before submitting
//file -> settings -> plugins -> download findbugs
package OOP_Project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

/**
 *The controller class holds all the values from the objects being used in the GUI.
 *@author Christopher Thorn
 */
public class Controller {

  @FXML
  private TextField TextFieldProductName;

  @FXML
  private TextField TextFieldManufacturer;

  @FXML
  private ChoiceBox<ItemType> ChoiceBoxItemType;

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
   *
   * @param mouseEvent allows the button click action to occur.
   */
  public void display(javafx.scene.input.MouseEvent mouseEvent) {
    ItemType test = ChoiceBoxItemType.getValue();

    String SQLStatement = "INSERT INTO PRODUCT(Type, Manufacturer, Name) VALUES ('" + test.getType() + "', "
            + "'"
            + TextFieldManufacturer.getText()
            + "', '"
            + TextFieldProductName.getText()
            + "')";

    //pass the sql statement from SQLStatement to  the method sqlExecute in Main.
    Main.sqlExecute(SQLStatement);
  }

  /**
   * The initialize method creates the numbered list for the comboBox from 1-10 and allows the user to make a selection
   * and edit previous selections. This also populates the choice box with the ItemType values.
   */
  @FXML
  private void initialize() {
    ComboBoxChooseQuantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9",
            "10");
    ComboBoxChooseQuantity.getSelectionModel().selectFirst();
    ComboBoxChooseQuantity.setEditable(true);
    ChoiceBoxItemType.getItems().setAll(ItemType.values());
    testMultimedia();
  }

  public static void testMultimedia() {
    AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
            "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
    Screen newScreen = new Screen("720x480", 40, 22);
    MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
            MonitorType.LCD);
    ArrayList<MultimediaControl> productList = new ArrayList<MultimediaControl>();
    productList.add(newAudioProduct);
    productList.add(newMovieProduct);
    for (MultimediaControl p : productList) {
      System.out.println(p);
      p.play();
      p.stop();
      p.next();
      p.previous();
    }
  }
}

