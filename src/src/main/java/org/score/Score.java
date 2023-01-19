package org.score;

public class Score {
    private String playerName;
    private int scoreValue;
    private String date;

    // constructor to initialize the score
    public Score(String playerName, int scoreValue, String date) {
        this.playerName = playerName;
        this.scoreValue = scoreValue;
        this.date = date;
    }

    // get and set methods for playerName
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    // get and set methods for scoreValue
    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    // get and set methods for date
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // method to compare scores
    public int compareTo(Score other) {
        return Integer.compare(this.scoreValue, other.scoreValue);
    }

}
