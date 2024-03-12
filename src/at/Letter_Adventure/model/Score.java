package at.Letter_Adventure.model;

public class Score {

    private int score;

    public Score() {
        this.score = 0;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
