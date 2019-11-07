//make sure to do ANALYZE AND THEN INSPECT CODE to check for my grade before submitting
//file -> settings -> plugins -> download findbugs
package OOP_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.dc.pr.PRError;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Date;

/**
 *The controller class holds all the values from the objects being used in the GUI.
 *@author Christopher Thorn
 */
public class ProductionTabController extends Main {

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

  @FXML
  private TextArea ProductLogTextArea;

  @FXML
  private TableView<Product> tableview;

  @FXML
  private TableColumn<String, Product> columnName;

  @FXML
  private TableColumn<String, Product> columnManufacturer;

  @FXML
  private TableColumn<String, Product> columnType;

  /**
   * The display method executes a button click mouse event when the "Add Product" button on the
   * Product Line tab is pushed. Once the button is pushed all information in Product Name and
   * Manufacturer Text fields is saved.
   * mouseEvent displays under Analyze code as a warning however it is needed to run the button
   * click action.
   *
   * @param mouseEvent allows the button click action to occur.
   */
  public void handleAddProduct(javafx.scene.input.MouseEvent mouseEvent) {
    ItemType grabItemType = ChoiceBoxItemType.getValue();

    String SQLStatement = "INSERT INTO PRODUCT(Type, Manufacturer, Name) VALUES ('" + grabItemType.getCode() + "', "
            + "'"
            + TextFieldManufacturer.getText()
            + "', '"
            + TextFieldProductName.getText()
            + "')";

    Widget addProduct = new Widget(TextFieldProductName.getText(), TextFieldManufacturer.getText(),grabItemType);
    productLine.add(addProduct);

    //pass the sql statement from SQLStatement to  the method sqlExecute in Main.
    Main.sqlExecute(SQLStatement);

    System.out.println("this is the arrayList \n" + productLine.toString()  );
    System.out.println("this is the observable list \n" + productList().toString()  );

    tableview.getItems().addAll(addProduct);

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
    ChoiceBoxItemType.getSelectionModel().selectFirst();
    testMultimedia();

    /**
     * (ONLY TEMPORARY) VARIABLE PR of object ProductRecord used with ProductRecord methods toString method to display
     * output..
     */
    ProductionRecord PR = new ProductionRecord(0, 2, "0", new Date());
    ProductLogTextArea.setText(PR.toString());

    /**
     *call to our method which sets the columns and does the cellValueFactory.
     */
      setupProductLineTable();
  }

//sets the observable list = to the array list
   ObservableList<Product> productList(){
    return FXCollections.observableArrayList(productLine);

  }

    public static void testMultimedia () {
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

    /**
     * method which holds the Observable list and also sets the call factory values along with setting the columns.
     */
    public void setupProductLineTable(){
        ObservableList<Product> productList = productList();
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableview.setItems(productList);
    }

}

