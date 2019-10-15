package OOP_Project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main.java file holds information that works with the controller.java and the ProductLineDB.
 * The file creates and initialize a working database along with execution sql statements to the
 * database.
 *@author Christopher Thorn
 */

public class Main extends Application {
  /**
   * The Statement stmt is declared globally to be used in executing the SQL statement in the
   * sqlExecute method.
   */

  private static Statement stmt;

  /**
   * The start method is the starting point of a JavaFX program. This start method sets the title.
   * @param primaryStage This is used to create the scene for the program to run.
   * @throws Exception any problem with the code.
   */

  @Override
  public void start(Stage primaryStage) throws Exception {
    //establish database connection
    initializeDB();
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Product Line Tracker");
    primaryStage.setScene(new Scene(root, 640, 600));
    primaryStage.show();
  }

  /**
   * The sqlExecute method takes a string SQLStatement as an argument an executes an sql statement
   * from data that was obtained in the GUi product Name and Manufacturer Textfield.
   * @param SQLStatement The users manufacturer and name selection.
   */

  public static void sqlExecute(String SQLStatement) {
    try {
      stmt.executeUpdate(SQLStatement);
      System.out.println(SQLStatement);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * The initializeDB method creates a connection to the database and sets the credentials.
   */

  private void initializeDB() {
    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./res/ProductLineDB";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;

    try {
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();

    } catch (Exception ex) {
      ex.printStackTrace();
    }//end try catch
  }//end method initializeDB


    //create a collection called productLine
    ArrayList <Product> productLine = new ArrayList<Product>();

  /**
   * The main method is empty for now but will eventually contain information.
   * @param args an argument.
   */

  public static void main(String[] args) {
      launch(args);
  }
}
