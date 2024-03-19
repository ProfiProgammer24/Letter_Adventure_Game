package at.Letter_Adventure.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Word {

    private String currentWord;
    private int correctWordIndex;

    private static final Map<String, String> hints = new HashMap<>();

    static {
        hints.put("Apple", "Es ist rund und rot.");
        hints.put("Banana", "Es ist lang und gelb und du isst es.");
        hints.put("Cat", "Es ist ein flauschiges Tier, das miaut.");
        hints.put("Dog", "Es ist ein treues Haustier, das bellt.");
        hints.put("House", "Es ist das Zuhause, in dem du lebst.");
        hints.put("Car", "Es hat vier Räder und fährt auf der Straße.");
        hints.put("Tree", "Es ist groß und hat viele grüne Blätter.");
        hints.put("Flower", "Es ist bunt und duftet schön.");
        hints.put("Sun", "Es ist gelb und scheint am Himmel.");
        hints.put("Moon", "Es ist weiß und scheint in der Nacht.");
        hints.put("Water", "Es ist klar und du trinkst es.");
        hints.put("Food", "Es ist etwas, das du isst, um stark zu werden.");
        hints.put("Drink", "Es ist etwas, das du trinkst, wenn du Durst hast.");
        hints.put("Book", "Es ist etwas, das du liest und viele Bilder hat.");
        hints.put("Pen", "Es ist etwas, das du benutzt, um zu schreiben.");
        hints.put("School", "Es ist ein Ort, an dem du lernst und Freunde triffst.");
        hints.put("Teacher", "Es ist jemand, der dir beibringt, neue Dinge zu lernen.");
        hints.put("Student", "Es ist jemand, der in der Schule lernt.");
        hints.put("Friend", "Es ist jemand, mit dem du gerne Zeit verbringst und spielst.");
        hints.put("Family", "Es sind die Menschen, die dich lieben und für dich da sind.");
        hints.put("Mother", "Es ist die Frau, die dich geboren hat und sich um dich kümmert.");
        hints.put("Father", "Es ist der Mann, der dich liebt und beschützt.");
        hints.put("Brother", "Es ist ein Junge, der mit dir zusammen aufwächst.");
        hints.put("Sister", "Es ist ein Mädchen, das deine Freundin ist und mit dir spielt.");
        hints.put("Baby", "Es ist klein und niedlich und schreit manchmal.");
        hints.put("Boy", "Es ist ein kleiner Mann, der gerne draußen spielt.");
        hints.put("Girl", "Es ist ein kleines Mädchen, das gerne Puppen spielt.");
        hints.put("Happy", "Es ist ein Gefühl, wenn du lächelst und fröhlich bist.");
        hints.put("Sad", "Es ist ein Gefühl, wenn du weinst und traurig bist.");
        hints.put("Love", "Es ist ein starkes Gefühl, das du für jemanden hast, den du magst.");
        hints.put("Hate", "Es ist ein starkes Gefühl, das du für etwas hast, das du nicht magst.");
        hints.put("Good", "Es ist etwas, das richtig und nett ist.");
        hints.put("Bad", "Es ist etwas, das falsch und nicht nett ist.");
        hints.put("Big", "Es ist groß und hat viel Platz.");
        hints.put("Small", "Es ist klein und passt in deine Hand.");
        hints.put("Hot", "Es ist sehr warm und macht dich schwitzen.");
        hints.put("Cold", "Es ist sehr kalt und du zitterst.");
        hints.put("Day", "Es ist die Zeit, wenn die Sonne scheint.");
        hints.put("Night", "Es ist die Zeit, wenn der Mond am Himmel ist.");
        hints.put("Time", "Es ist etwas, das du auf einer Uhr ablesen kannst.");
        hints.put("Money", "Es sind Münzen und Scheine, die du benutzt, um Dinge zu kaufen.");
        hints.put("Color", "Es ist etwas, das Dinge bunt macht.");
        hints.put("Red", "Es ist eine Farbe wie eine reife Tomate.");
        hints.put("Blue", "Es ist eine Farbe wie der Himmel an einem sonnigen Tag.");
        hints.put("Green", "Es ist eine Farbe wie das Gras auf einer Wiese.");
        hints.put("Yellow", "Es ist eine Farbe wie die Sonne am Morgen.");
        hints.put("Orange", "Es ist eine Farbe wie eine reife Orange.");
        hints.put("Black", "Es ist eine Farbe wie die Nacht.");
        hints.put("White", "Es ist eine Farbe wie der Schnee im Winter.");
        hints.put("One", "Es ist die Zahl nach null und vor zwei.");
        hints.put("Two", "Es ist die Zahl nach eins und vor drei.");
        hints.put("Three", "Es ist die Zahl nach zwei und vor vier.");
        hints.put("Four", "Es ist die Zahl nach drei und vor fünf.");
        hints.put("Five", "Es ist die Zahl nach vier und vor sechs.");
        hints.put("Six", "Es ist die Zahl nach fünf und vor sieben.");
        hints.put("Seven", "Es ist die Zahl nach sechs und vor acht.");
        hints.put("Eight", "Es ist die Zahl nach sieben und vor neun.");
        hints.put("Nine", "Es ist die Zahl nach acht und vor zehn.");
        hints.put("Ten", "Es ist die Zahl nach neun und vor elf.");
        hints.put("Hello", "Es ist ein freundlicher Gruß, den du zu anderen sagst.");
        hints.put("Goodbye", "Es ist ein Abschiedsgruß, wenn du gehst.");
        hints.put("Please", "Es ist ein höfliches Wort, das du benutzt, wenn du um etwas bittest.");
        hints.put("Thank you", "Es ist ein Dankeschön, das du sagst, wenn dir jemand hilft.");
        hints.put("Sorry", "Es ist ein Entschuldigung, das du sagst, wenn du jemanden verletzt hast.");
        hints.put("Yes", "Es ist eine Zustimmung, wenn du mit etwas einverstanden bist.");
        hints.put("No", "Es ist eine Ablehnung, wenn du mit etwas nicht einverstanden bist.");
        hints.put("How are you?", "Es ist eine Frage danach, wie es dir geht.");
        hints.put("I'm fine", "Es ist eine Antwort darauf, wenn es dir gut geht.");
        hints.put("What is your name?", "Es ist eine Frage nach deinem Namen.");
        hints.put("My name is...", "Es ist eine Antwort darauf, wie du heißt.");
        hints.put("Where is the bathroom?", "Es ist eine Frage danach, wo das Klo ist.");
        hints.put("I love you", "Es ist etwas Nettes, das du zu jemandem sagst, den du sehr magst.");
        hints.put("Happy birthday", "Es ist ein besonderer Tag, an dem du Geburtstag feierst.");
        hints.put("Good morning", "Es ist der Gruß, den du am Morgen verwendest.");
        hints.put("Good afternoon", "Es ist der Gruß, den du am Nachmittag verwendest.");
        hints.put("Good evening", "Es ist der Gruß, den du am Abend verwendest.");
        hints.put("Good night", "Es ist der Abschiedsgruß, wenn du ins Bett gehst.");
        hints.put("Excuse me", "Es ist das, was du sagst, wenn du die Aufmerksamkeit von jemandem möchtest.");
        hints.put("I don't understand", "Es ist das, was du sagst, wenn du etwas nicht verstehst.");
        hints.put("Can you help me?", "Es ist die Frage, die du stellst, wenn du Hilfe brauchst.");
        hints.put("How much does this cost?", "Es ist die Frage, die du stellst, wenn du den Preis von etwas wissen möchtest.");
        hints.put("What time is it?", "Es ist die Frage, die du stellst, wenn du die Uhrzeit wissen möchtest.");
        hints.put("Where is the nearest hospital?", "Es ist die Frage, die du stellst, wenn du medizinische Hilfe brauchst.");
        hints.put("Please give me a glass of water", "Es ist das, was du sagst, wenn du Durst hast und Wasser möchtest.");
        hints.put("I'm lost", "Es ist das, was du sagst, wenn du dich verirrt hast und den Weg nicht kennst.");
        hints.put("I need a taxi", "Es ist das, was du sagst, wenn du ein Taxi rufen möchtest.");
        hints.put("Where can I find a restaurant?", "Es ist die Frage, die du stellst, wenn du hungrig bist und Essen möchtest.");
        hints.put("This is delicious", "Es ist das, was du sagst, wenn dir das Essen sehr gut schmeckt.");
        hints.put("I'm allergic to peanuts", "Es ist das, was du sagst, wenn du keine Erdnüsse essen kannst.");
        hints.put("Can you recommend a good movie?", "Es ist die Frage, die du stellst, wenn du einen guten Film sehen möchtest.");
        hints.put("I like to travel", "Es ist das, was du sagst, wenn du gerne an verschiedene Orte gehst.");
        hints.put("What's the weather like today?", "Es ist die Frage, die du stellst, wenn du wissen möchtest, wie das Wetter ist.");
        hints.put("I'm tired", "Es ist das, was du sagst, wenn du müde bist und schlafen möchtest.");
        hints.put("Are you okay?", "Es ist die Frage, die du stellst, wenn du dich um jemanden sorgst.");
        hints.put("I'm hungry", "Es ist das, was du sagst, wenn du hungrig bist und etwas essen möchtest.");
        hints.put("I'm thirsty", "Es ist das, was du sagst, wenn du Durst hast und etwas trinken möchtest.");
        hints.put("It's beautiful here", "Es ist das, was du sagst, wenn du einen schönen Ort siehst.");
        hints.put("I'm excited", "Es ist das, was du sagst, wenn du aufgeregt bist und etwas Besonderes passiert.");
        hints.put("Can you speak slower, please?", "Es ist die Frage, die du stellst, wenn jemand zu schnell spricht.");
        hints.put("I'm from Austria", "Es ist das, was du sagst, wenn du aus Österreich kommst.");
    }

    public String generateHint(String currentWord) {
        currentWord = hints.get(this.currentWord);
        return currentWord != null ? currentWord : "No hint available";
    }



    private static final String[] englishWords = {
            "Apple", "Banana", "Cat", "Dog", "House", "Car", "Tree", "Flower", "Sun", "Moon",
            "Water", "Food", "Drink", "Book", "Pen", "School", "Teacher", "Student", "Friend", "Family",
            "Mother", "Father", "Brother", "Sister", "Baby", "Boy", "Girl", "Happy", "Sad", "Love",
            "Hate", "Good", "Bad", "Big", "Small", "Hot", "Cold", "Day", "Night", "Time", "Money",
            "Color", "Red", "Blue", "Green", "Yellow", "Orange", "Black", "White", "One", "Two", "Three",
            "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Hello", "Goodbye", "Please",
            "Thank you", "Sorry", "Yes", "No", "How are you?", "I'm fine", "What is your name?", "My name is...",
            "Where is the bathroom?", "I love you", "Happy birthday", "Good morning", "Good afternoon",
            "Good evening", "Good night", "Excuse me", "I don't understand", "Can you help me?",
            "How much does this cost?", "What time is it?", "Where is the nearest hospital?",
            "Please give me a glass of water", "I'm lost", "I need a taxi",
            "Where can I find a restaurant?", "This is delicious", "I'm allergic to peanuts",
            "Can you recommend a good movie?", "I like to travel", "What's the weather like today?",
            "I'm tired", "Are you okay?", "I'm hungry", "I'm thirsty", "It's beautiful here",
            "I'm excited", "Can you speak slower, please?", "I'm from Austria"
    };

    private static final String[] germanTranslations = {
            "Apfel", "Banane", "Katze", "Hund", "Haus", "Auto", "Baum", "Blume", "Sonne", "Mond",
            "Wasser", "Essen", "Trinken", "Buch", "Stift", "Schule", "Lehrer", "Schüler", "Freund", "Familie",
            "Mutter", "Vater", "Bruder", "Schwester", "Baby", "Junge", "Mädchen", "Glücklich", "Traurig", "Liebe",
            "Hass", "Gut", "Schlecht", "Groß", "Klein", "Heiß", "Kalt", "Tag", "Nacht", "Zeit", "Geld",
            "Farbe", "Rot", "Blau", "Grün", "Gelb", "Orange", "Schwarz", "Weiß", "Eins", "Zwei", "Drei",
            "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn", "Hallo", "Auf Wiedersehen", "Bitte",
            "Danke", "Entschuldigung", "Ja", "Nein", "Wie geht es dir?", "Mir geht es gut", "Wie heißt du?",
            "Ich heiße...", "Wo ist die Toilette?", "Ich liebe dich", "Alles Gute zum Geburtstag", "Guten Morgen", "Guten Tag",
            "Guten Abend", "Gute Nacht", "Entschuldigen Sie", "Ich verstehe nicht", "Können Sie mir helfen?",
            "Wie viel kostet das?", "Wie spät ist es?", "Wo ist das nächste Krankenhaus?",
            "Bitte geben Sie mir ein Glas Wasser", "Ich habe mich verirrt", "Ich brauche ein Taxi",
            "Wo finde ich ein Restaurant?", "Das schmeckt köstlich", "Ich bin allergisch gegen Erdnüsse",
            "Können Sie einen guten Film empfehlen?", "Ich reise gerne", "Wie ist das Wetter heute?",
            "Ich bin müde", "Geht es dir gut?", "Ich habe Hunger", "Ich habe Durst", "Es ist wunderschön hier",
            "Ich bin aufgeregt", "Können Sie langsamer sprechen, bitte?", "Ich komme aus Österreich"
    };

    public static String getRandomEnglishWord() {
        Random random = new Random();
        return englishWords[random.nextInt(englishWords.length)];
    }

    public static String getGermanTranslation(String englishWord) {
        for (int i = 0; i < englishWords.length; i++) {
            if (englishWords[i].equals(englishWord)) {
                return germanTranslations[i];
            }
        }
        return null; // Wenn keine Übersetzung gefunden wurde
    }

    public static String[] getEnglishWords() {
        return englishWords;
    }

    public void generateNewWord() {
        // Zufällige Auswahl eines neuen Wortes
        currentWord = getRandomEnglishWord();
        correctWordIndex = findCorrectWordIndex(currentWord);
        // Weitere Logik, um die Anzeige zu aktualisieren oder an den Controller zu übergeben
    }

    public boolean checkAnswer(String selectedWord) {
        // Überprüfe, ob das ausgewählte deutsche Wort die richtige Übersetzung ist
        return selectedWord.equals(getGermanTranslation(currentWord));
    }

    private int findCorrectWordIndex(String word) {
        for (int i = 0; i < getEnglishWords().length; i++) {
            if (getEnglishWords()[i].equals(word)) {
                return i;
            }
        }
        return -1; // Wenn das Wort nicht gefunden wurde
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public String[] generateWordOptions() {
        // Erstelle eine zufällige Liste von deutschen Übersetzungen (einschließlich der richtigen Antwort)
        String[] options = new String[3];
        options[0] = germanTranslations[correctWordIndex]; // Die deutsche Übersetzung des aktuellen englischen Wortes

        // Wähle zufällige deutsche Übersetzungen für die anderen Optionen
        for (int i = 1; i < options.length; i++) {
            options[i] = getRandomGermanTranslation();
        }
        shuffleArray(options);
        return options;
    }

    private void shuffleArray(String[] array) {
        // Mische die Elemente im Array (Fisher-Yates-Mischalgorithmus)
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private String getRandomGermanTranslation() {
        // Hier kannst du die Logik einfügen, um zufällige deutsche Übersetzungen zu generieren.
        // Zum Beispiel könntest du ein Array von deutschen Übersetzungen für die englischen Wörter haben
        // und dann zufällig eine davon auswählen.

        Random random = new Random();
        return germanTranslations[random.nextInt(germanTranslations.length)];
    }
}
