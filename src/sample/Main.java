package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Christopher Thorn
 */
public class Main extends Application {

  /**
   *The start method is the starting point of a JavaFX program. This start method sets the title.
   *  @brief
   * @param primaryStage
   * @throws Exception any problem with the code.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  /**
   * @brief
   * @param args
   */

  public static void main(String[] args) {
    launch(args);
  }
}
