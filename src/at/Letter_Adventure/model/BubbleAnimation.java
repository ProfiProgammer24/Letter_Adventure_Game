package at.Letter_Adventure.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class BubbleAnimation {

    public static void animateBubbles(Pane pane_bubbles) {
        // Erstelle eine Timeline für die Bubble-Animation
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); // Endlose Wiederholung

        // Füge Keyframes hinzu, um die Bubbles hin und her zu bewegen
        KeyFrame moveBubbles = new KeyFrame(Duration.seconds(0.05), event -> {
            // Bewege die Bubbles nach links oder rechts
            for (Node bubble : pane_bubbles.getChildren()) {
                // Hole die aktuelle Position der Bubble
                double currentX = bubble.getLayoutX();
                double currentY = bubble.getLayoutY();

                // Berechne die neue Position basierend auf der aktuellen Position und der Bewegungsgeschwindigkeit
                double newX = currentX + (Math.random() - 0.5) * 5; // Zufällige Bewegung nach links oder rechts
                double newY = currentY + (Math.random() - 0.5) * 5; // Zufällige Bewegung nach oben oder unten

                // Stelle sicher, dass die neue Position innerhalb der Grenzen des Pane liegt
                newX = Math.max(0, Math.min(pane_bubbles.getWidth() - bubble.getBoundsInLocal().getWidth(), newX));
                newY = Math.max(0, Math.min(pane_bubbles.getHeight() - bubble.getBoundsInLocal().getHeight(), newY));

                // Setze die neue Position der Bubble
                bubble.setLayoutX(newX);
                bubble.setLayoutY(newY);
            }
        });

        timeline.getKeyFrames().add(moveBubbles);

        // Starte die Animation
        timeline.play();
    }
}
