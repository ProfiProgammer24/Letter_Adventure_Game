package at.Letter_Adventure.model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class BubbleAnimation {

    private Set<Node> bubbles = new HashSet<>(); // Verwende ein Set, um Überlappungen zu verhindern
    private boolean firstRun = true;
    private boolean secondRun = true;

    public void startAnimation(Pane pane_bubbles) {
        final double MIN_DISTANCE = 50;
        final double MAX_MOVE_DISTANCE = 0.15; // Reduzierte Pixelanzahl pro Bewegung
        int counter  = 0;

        for (Node bubble : pane_bubbles.getChildren()) {
            if (firstRun) {
                counter = 200;
                firstRun = false;
            }
            else if(secondRun){
                counter = 100;
                secondRun = false;
            }
            else{
                counter = 0;
            }
            initializeBubble(bubble, pane_bubbles,counter);
            animateBubble(bubble, pane_bubbles, MIN_DISTANCE, MAX_MOVE_DISTANCE);
        }
    }


    private void initializeBubble(Node bubble, Pane pane_bubbles, int counter) {
        double startX, startY;

        do {
            // Zufällige Startposition für die Bubble
            startX = Math.random() * (pane_bubbles.getWidth() - bubble.getBoundsInLocal().getWidth());
            startY = Math.random() * (pane_bubbles.getHeight() - bubble.getBoundsInLocal().getHeight());
        } while (checkOverlap(bubble, startX, startY));

        bubble.setTranslateX(startX + counter);
        bubble.setTranslateY(startY + counter);
        bubbles.add(bubble);
    }

    private boolean checkOverlap(Node bubble, double x, double y) {
        for (Node otherBubble : bubbles) {
            double otherX = otherBubble.getTranslateX();
            double otherY = otherBubble.getTranslateY();

            double distance = Math.sqrt(Math.pow(x - otherX, 2) + Math.pow(y - otherY, 2));

            if (distance < bubble.getBoundsInLocal().getWidth()) {
                return true; // Überlappung gefunden
            }
        }
        return false; // Keine Überlappung
    }

    private void animateBubble(Node bubble, Pane pane_bubbles, double minDistance, double maxMoveDistance) {
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        // Initialisiere die Bewegungsrichtung der Bubble
        double[] direction = {1, 1}; // Startet mit einer diagonalen Richtung nach rechts unten

        // Füge einen KeyFrame hinzu, der die Bubble kontinuierlich bewegt
        KeyFrame keyFrame = new KeyFrame(
                Duration.seconds(0.001),
                event -> moveBubble(bubble, pane_bubbles, minDistance, maxMoveDistance, direction)
        );

        timeline.getKeyFrames().add(keyFrame);

        // Starte die Timeline
        timeline.play();
    }

    private void moveBubble(Node bubble, Pane pane_bubbles, double minDistance, double maxMoveDistance, double[] direction) {
        // Aktuelle Position der Blase
        double currentX = bubble.getTranslateX();
        double currentY = bubble.getTranslateY();

        // Neue Positionen
        double newX = currentX + direction[0] * maxMoveDistance;
        double newY = currentY + direction[1] * maxMoveDistance;

        // Überprüfe, ob die Bubble eine Wand erreicht hat und ändere die Richtung
        if (newX <= 0 || newX >= pane_bubbles.getWidth() - bubble.getBoundsInLocal().getWidth()) {
            direction[0] *= -1; // Ändere die X-Richtung
        }
        if (newY <= 0 || newY >= pane_bubbles.getHeight() - bubble.getBoundsInLocal().getHeight()) {
            direction[1] *= -1; // Ändere die Y-Richtung
        }

        // Bewege die Bubble zu der neuen Position
        bubble.setTranslateX(newX);
        bubble.setTranslateY(newY);
    }
}
