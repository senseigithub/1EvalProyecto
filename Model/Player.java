package Model;

import java.util.Arrays;

public class Player {
    private String name;
    private int score;
    private int numCards;
    private Card[] hand = new Card[20];
    private boolean isDealer;

    public Player(String name, int score,int numCards, boolean isDealer) {
        this.name = name;
        this.score = score;
        this.numCards = numCards;
        this.isDealer = isDealer;
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

    public int getNumCard() {
        return numCards;
    }

    public void setNumCard(int numCard) {
        this.numCards = numCard;
    }

    public Card[] getHand() {
        return hand;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }


    public void setDealer(boolean dealer) {
        isDealer = dealer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", numCard=" + numCards +
                ", hand=" + Arrays.toString(hand) +
                ", isDealer=" + isDealer +
                '}';
    }

    public void addToHand(Card card) {
        if (numCards < hand.length) {
            hand[numCards] = card;
            numCards++;
        } else {
            System.out.println("La mano esta llena. No puedes añadir más cartas");
        }
    }

    public void clearHand() {
        for (int i = 0; i < numCards; i++) {
            hand[i] = null;
        }
        numCards = 0;
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (int i = 0; i < numCards; i++) {
            int cardValue = hand[i].getValue();

            // Ajusta el valor si es 11, 12 o 13
            if (cardValue >= 11 && cardValue <= 13) {
                cardValue = 10;
            }

            value += cardValue;

            if (hand[i].isAce()) {
                numAces++;
            }
        }

        while (numAces > 0 && value > 21) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public boolean isAce() {
        // Este método indica si hay al menos un AS en la mano del jugador.
        // El valor de un AS es 11 cuando el valor total de la mano del jugador es menor a 11.

        for (int i = 0; i < numCards; i++) {
            if (hand[i] != null && hand[i].isAce() && getHandValue() < 11) {
                return true;
            }
        }
        return false;
    }

    public boolean isDealer() {
        return isDealer;
    }


    public void printHand() {
        for (int i = 0; i < numCards; i++) {
            System.out.print(hand[i] + " ");
        }
        System.out.println();
    }
}
