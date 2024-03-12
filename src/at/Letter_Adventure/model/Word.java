package at.Letter_Adventure.model;

import java.util.Random;

public class Word {

    private String currentWord;
    private int correctWordIndex;

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
