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
import javafx.stage.Stage;

public class Main extends Application {

    Letter_Adventure_Menu_Control menu_control = new Letter_Adventure_Menu_Control();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/at/Letter_Adventure/view/menu.fxml"));
        primaryStage.setTitle("Letter Adventure");
        primaryStage.setScene(new Scene(root, 1153, 697));
        primaryStage.show();

        /*
        if (menu_control.handleAction().equals("true")){
            primaryStage.close();
        }

         */

    }


    public static void main(String[] args) {
        launch(args);
    }
}

