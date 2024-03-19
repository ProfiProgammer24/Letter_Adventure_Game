/*
erstellt von: Sami Cehic
erstellt am: 23.12
Beschreibung: Temperaturstatistik
 */

package at.Letter_Adventure.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/menu.fxml"));
        Parent root = loader.load();
        Letter_Adventure_Menu_Control controller = loader.getController();
        controller.setMenuStage(primaryStage); // Übergibt die Hauptbühnenreferenz
        primaryStage.setScene(new Scene(root, 1153, 697));
        primaryStage.getIcons().add(new Image("/bild/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
