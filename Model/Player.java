package Model;

import java.util.Arrays;

public class Player {
    private String name;
    private int score;
    private Card[] hand;

    public Player(String name, int score, Card[] hand) {
        this.name = name;
        this.score = score;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", hand=" + Arrays.toString(hand) +
                '}';
    }
}
