//make sure to do ANALYZE AND THEN INSPECT CODE to check for my grade before submitting
//file -> settings -> plugins -> download findbugs
package OOP_Project;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.naming.Name;
import javax.xml.crypto.Data;
import javax.xml.transform.Result;
import java.rmi.Naming;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * The controller class holds all the values from the objects being used in the GUI.
 *
 * @author Christopher Thorn
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

    @FXML
    private TextField FirstNameText;

    @FXML
    private TextField UserNameText;

    @FXML
    private TextField EmailText;

    @FXML
    private ListView<Product> listProduce;

    ArrayList<ProductionRecord> productionRun = new ArrayList<>();
    private int countItems;
    ArrayList<ProductionRecord> productionLog = new ArrayList<>();


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

        //pass the sql statement from SQLStatement to  the method sqlExecute in Main.
        Main.sqlExecute(SQLStatement);
        loadProductList();
        System.out.println("this is the arrayList \n" + productLine.toString());
        System.out.println("this is the observable list \n" + productList().toString());
        TextFieldProductName.clear();
        TextFieldManufacturer.clear();
    }

    @FXML
    void handleRecordProduction(MouseEvent event) {
        // create for loop that uses for ( i = 0, i < comboBoxChooseQuantity
        for (int i = 0; i < Integer.parseInt(ComboBoxChooseQuantity.getValue()); i++) {
            //add production record obj to production run array list
            productionRun.add(new ProductionRecord(listProduce.getSelectionModel().getSelectedItem(), countItems));
            countItems++;

        }
        addToProductionDB(productionRun);
        loadProductionLog();
        showProduction();

    }

    /**
     * The initialize method creates the numbered list for the comboBox from 1-10 and allows the user to make a selection
     * and edit previous selections. This also populates the choice box with the ItemType values.
     */
    @FXML
    private void initialize() {
        ComboBoxChooseQuantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10");
        ComboBoxChooseQuantity.setEditable(true);
        ComboBoxChooseQuantity.getSelectionModel().selectFirst();
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
        loadProductList();
        loadProductionLog();
    }

    /**
     * sets the observable list = to the array list
     *
     * @return returns the Array list
     */
    ObservableList<Product> productList() {
        return FXCollections.observableArrayList(productLine);

    }

    public static void testMultimedia() {
        /*AudioPlayer newAudioProduct = new AudioPlayer("DP-X1A", "Onkyo",
                "DSD/FLAC/ALAC/WAV/AIFF/MQA/Ogg-Vorbis/MP3/AAC", "M3U/PLS/WPL");
        Screen newScreen = new Screen("720x480", 40, 22);
        MoviePlayer newMovieProduct = new MoviePlayer("DBPOWER MK101", "OracleProduction", newScreen,
                MonitorType.LCD);
        ArrayList<MultimediaControl> productList = new ArrayList<>();
        productList.add(newAudioProduct);
        productList.add(newMovieProduct);
        for (MultimediaControl p : productList) {
            System.out.println(p);
            p.play();
            p.stop();
            p.next();
            p.previous();
        }*/
    }

    /**
     * method which holds the Observable list and also sets the call factory values along with setting the columns.
     */
    public void setupProductLineTable() {
        ObservableList<Product> productList = productList();
        productList = FXCollections.observableArrayList();

        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnManufacturer.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        try {
            String SQLStatement = "SELECT * FROM productList";
            System.out.println("selected products");

        } catch (Exception e) {
            e.printStackTrace();
        }
        tableview.setItems(productList);
    }

    public void loadProductList() {
        Connection conn = Main.initializeDB();
        productLine.clear();
        if (conn != null)
            try {
                String SQL = "SELECT * FROM PRODUCT";
                PreparedStatement pstatement = conn.prepareStatement(SQL);
                ResultSet rset = pstatement.executeQuery();

                while (rset.next()) {
                    int id = rset.getInt("ID");
                    String name = rset.getString("NAME");
                    String code = rset.getString("TYPE");
                    String manufacturer = rset.getString("MANUFACTURER");

                    for (ItemType type : ItemType.values()) {
                        if (type.getCode().equals(code)) {
                            productLine.add(new Widget(id, name, manufacturer, type));
                        }
                    }
                }

                tableview.getItems().clear();
                tableview.getItems().addAll(productLine);

                listProduce.getItems().clear();
                listProduce.getItems().addAll(productLine);

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void loadProductionLog() {
        Connection conn = Main.initializeDB();
        if (conn != null)
            try {
                String SQL = "SELECT * FROM PRODUCTIONRECORD";
                PreparedStatement pstatement = conn.prepareStatement(SQL);
                ResultSet rset = pstatement.executeQuery();

                while (rset.next()) {
                    int number = rset.getInt("PRODUCTION_NUM");
                    int id = rset.getInt("PRODUCT_ID");
                    String serialNum = rset.getString("SERIAL_NUM");
                    Timestamp date = rset.getTimestamp("DATE_PRODUCED");
                    productionLog.add(new ProductionRecord(number, id, serialNum, date));
                    countItems++;

                }
                showProduction();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void addToProductionDB(ArrayList<ProductionRecord> productionRun) {
        Connection conn = Main.initializeDB();
        try {
            String SQL = "INSERT INTO PRODUCTIONRECORD (PRODUCT_ID,SERIAL_NUM,DATE_PRODUCED) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            for (ProductionRecord pr : productionRun) {
                pr.setProductID(getProductId(pr.getProductionName()));

                ps.setInt(1, pr.getProductID());
                ps.setString(2, pr.getSerialNumber());
                ps.setDate(3, new java.sql.Date(new Date().getTime()));
                ps.executeUpdate();
            }
            productionRun.clear();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showProduction() {
        Connection conn = Main.initializeDB();
        for (ProductionRecord pr : productionLog) {
            try {
                String SQL = "SELECT NAME FROM PRODUCT WHERE ID = ?";
                PreparedStatement ps = conn.prepareStatement(SQL);
                ps.setInt(1, pr.getProductID());
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    pr.setProductionName(rs.getNString("NAME"));
                }
                ProductLogTextArea.appendText(pr.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int getProductId(String productName) {
        Connection conn = Main.initializeDB();
        int id = 0;
        try {
            String SQL = "SELECT ID FROM PRODUCT WHERE NAME = ?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, productName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}

