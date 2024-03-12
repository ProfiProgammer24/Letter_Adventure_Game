package at.Letter_Adventure.control;

import at.Letter_Adventure.model.Bubble;
import at.Letter_Adventure.model.BubbleAnimation;
import at.Letter_Adventure.model.Score;
import at.Letter_Adventure.model.Word;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Letter_Adventure_Control {

    @FXML
    private Label label_score;

    @FXML
    private Label label_wort;

    @FXML
    private Pane pane_bubbles;

    private Word wordModel;
    private Score scoreModel;

    public void initialize() {
        wordModel = new Word();
        scoreModel = new Score();

        startGame();
        BubbleAnimation.animateBubbles(pane_bubbles);
    }

    @FXML
    private void startGame() {
        wordModel.generateNewWord();
        updateWord();
        updateBubbles();
        updateScore();
    }

    @FXML
    private void handleBubbleClick(javafx.scene.input.MouseEvent event) {
        if (wordModel != null && scoreModel != null) {
            Label clickedBubble = (Label) event.getSource();
            String selectedWord = clickedBubble.getText();

            if (wordModel.checkAnswer(selectedWord)) {
                scoreModel.increaseScore();
                updateScore();
                startGame();
            } else {
                // Falsche Antwort (könnte eine Animation oder Feedback hinzufügen)
            }
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
}
