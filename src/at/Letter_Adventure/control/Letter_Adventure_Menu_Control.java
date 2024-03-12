package at.Letter_Adventure.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Letter_Adventure_Menu_Control {

    @FXML
    public void handleAction(){
        try {
            String x = "";
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/at/Letter_Adventure/view/view.fxml"));
            primaryStage.setTitle("Letter Adventure");
            primaryStage.setScene(new Scene(root, 1153, 697));
            primaryStage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
