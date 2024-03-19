package at.Letter_Adventure.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Letter_Adventure_Menu_Control {

    private Stage menuStage; // Speichern Sie die Stage-Referenz des Menüfensters

    // Methode zum Setzen der Stage-Referenz
    public void setMenuStage(Stage menuStage) {
        this.menuStage = menuStage;
    }

    @FXML
    public void handleAction() {
        try {
            // Schließen des aktuellen Menüfensters
            menuStage.close();

            // Öffnen des neuen Fensters
            Stage newStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/view.fxml"));
            Parent root = loader.load();
            newStage.setTitle("Letter Adventure");
            newStage.setScene(new Scene(root, 1153, 697));
            newStage.show();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void handleInfo() throws IOException {
        Stage stageInfo = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/info.fxml"));
        Parent root = loader.load();
        stageInfo.setTitle("Letter Adventure");
        stageInfo.setScene(new Scene(root, 600, 473));
        stageInfo.show();
    }
}
