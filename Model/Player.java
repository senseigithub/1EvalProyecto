package Model;

import java.util.Arrays;

public class Player {
    private String name;
    private int numCards;
    private Card[] hand = new Card[20];
    private boolean isDealer;

    public Player(String name, int score,int numCards, boolean isDealer) {
        this.name = name;
        this.numCards = numCards;
        this.isDealer = isDealer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", numCard=" + numCards +
                ", hand=" + Arrays.toString(hand) +
                ", isDealer=" + isDealer +
                '}';
    }

    public void addToHand(Card card) {
        // Verifica si hay espacio disponible en la mano para añadir otra carta.
        if (numCards < hand.length) {
            // Asigna la nueva carta a la posición correspondiente en la mano.
            hand[numCards] = card;
            // Incrementa el contador de cartas en la mano.
            numCards++;
        } else {
            System.out.println("La mano esta llena. No puedes añadir más cartas");
        }
    }


    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        // Recorre todas las cartas en la mano.
        for (int i = 0; i < numCards; i++) {
            // Obtiene el valor de la carta actual y no mete en cardValue.
            int cardValue = hand[i].getValue();

            // Ajusta el valor si es 11, 12 o 13
            if (cardValue >= 11 && cardValue <= 13) {
                cardValue = 10;
            }

            // Suma el valor de la carta al valor total de la mano.
            value += cardValue;

            // Verifica si la carta actual es un As.
            if (hand[i].isAce()) {
                // Incrementa el contador de Ases.
                numAces++;
            }
        }

        // Ajusta el valor por los Ases si es necesario.
        while (numAces > 0 && value > 21) {
            value -= 10;
            numAces--;
        }

        // Devuelve el valor total de la mano.
        return value;
    }


    public boolean isDealer() {
        return isDealer;
    }


    public void printHand() {
        // Recorre todas las cartas de la mano.
        for (int i = 0; i < numCards; i++) {
            // Imprime cada carta seguida de un espacio en la misma línea.
            System.out.print(hand[i] + " ");
        }
        // Después de imprimir todas las cartas, agrega una nueva línea para mejorar la presentación.
        System.out.println();
    }
}
