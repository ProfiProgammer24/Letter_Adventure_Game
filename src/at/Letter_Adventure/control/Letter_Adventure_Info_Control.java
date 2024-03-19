package at.Letter_Adventure.control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Letter_Adventure_Info_Control {

    @FXML
    Button btn_back;

@FXML
    public void getBack(){
    Stage stage = (Stage) btn_back.getScene().getWindow();
    stage.close();
}
}
