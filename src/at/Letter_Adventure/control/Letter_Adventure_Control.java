package at.Letter_Adventure.control;

import at.Letter_Adventure.model.Bubble;
import at.Letter_Adventure.model.BubbleAnimation;
import at.Letter_Adventure.model.Score;
import at.Letter_Adventure.model.Word;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Letter_Adventure_Control {

    @FXML
    private Label label_score;

    @FXML
    private Label label_wort;

    @FXML
    private Pane pane_bubbles;

    private Word wordModel;
    private Score scoreModel;

    private BubbleAnimation bubbleAnimation = new BubbleAnimation();
    public void initialize() {
        wordModel = new Word();
        scoreModel = new Score();

        startGame();

    }

    @FXML
    private void startGame() {
        wordModel.generateNewWord();
        updateWord();
        updateBubbles();
        updateScore();
        bubbleAnimation.startAnimation(pane_bubbles);
    }

    @FXML
    private void handleBubbleClick(javafx.scene.input.MouseEvent event) {
        if (wordModel != null && scoreModel != null) {
            Label clickedBubble = (Label) event.getSource();
            String selectedWord = clickedBubble.getText();

            if (wordModel.checkAnswer(selectedWord)) {
                scoreModel.increaseScore();
                if (scoreModel.getScore() == 2) {
                    openCongratsWindow();
                }
            } else {
                scoreModel.decreaseScore();
            }
            updateScore();
            startGame();
        }
    }

    private void openCongratsWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/congrats.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Letter Adventure");
            newStage.setScene(new Scene(root, 996, 235));
            newStage.show();

            // Schließen des aktuellen Fensters
            Stage currentStage = (Stage) pane_bubbles.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void updateWord() {
        String currentWord = wordModel.getCurrentWord();
        label_wort.setText(currentWord);
    }

    private void updateBubbles() {
        pane_bubbles.getChildren().clear();
        String[] options = wordModel.generateWordOptions();
        for (String option : options) {
            Label bubble = Bubble.createBubble(option);
            bubble.setOnMouseClicked(this::handleBubbleClick);
            pane_bubbles.getChildren().add(bubble);
        }
    }

    private void updateScore() {
        int score = scoreModel.getScore();
        label_score.setText(String.valueOf(score));
    }


    @FXML
    public void gebeHinweis() throws IOException {
        // Hinweis für das aktuelle Wort abrufen
        String hinweis = wordModel.generateHint(wordModel.getCurrentWord());

        // Hinweis-Fenster öffnen und den Hinweis anzeigen
        Stage hinweisStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/at/Letter_Adventure/view/hinweis.fxml"));
        Parent root = loader.load();
        hinweisStage.setTitle("Letter Adventure - Hinweis");
        hinweisStage.setScene(new Scene(root, 600, 160));
        hinweisStage.show();
        Letter_Adventure_Hinweis_Control hinweisController = loader.getController();
        hinweisController.setHint(hinweis); // Methode setHint() im Hinweis-Controller aufrufen, um den Hinweis zu setzen
    }

}
