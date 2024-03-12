package at.Letter_Adventure.model;

import javafx.scene.control.Label;

public class Bubble {

    public static Label createBubble(String word) {
        Label bubble = new Label(word);
        bubble.getStyleClass().add("bubble"); // CSS-Klasse für die Bubble-Stile
        // Klick-Handler hinzufügen oder in der Controller-Klasse implementieren
        return bubble;
    }
}
