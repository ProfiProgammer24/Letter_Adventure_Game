package at.Letter_Adventure.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Letter_Adventure_Hinweis_Control {

    @FXML
    Button btn_weiter;

    @FXML
    private TextField lbl_hinweis;
    @FXML
    public void getBack(){
        Stage stage = (Stage) btn_weiter.getScene().getWindow();
        stage.close();

    }

    public void setHint(String hint) {
        lbl_hinweis.setText(hint);
    }

}
