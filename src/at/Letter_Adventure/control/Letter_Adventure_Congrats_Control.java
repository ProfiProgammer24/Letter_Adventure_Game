package at.Letter_Adventure.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class Letter_Adventure_Congrats_Control {

    @FXML
    Button btn_startNew = new Button();

    @FXML
    public void startNewGame() {
        try {
            Stage congrStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/view.fxml"));
            Parent root = loader.load();
            congrStage.setTitle("Letter Adventure");
            congrStage.setScene(new Scene(root, 1153, 697));
            congrStage.show();

            Stage stage = (Stage) btn_startNew.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void endGame() {
        Stage stage = (Stage) btn_startNew.getScene().getWindow();
        stage.close();
    }

}
