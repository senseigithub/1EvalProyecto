package Model;


import java.util.Objects;

public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    public Card(){
        this(0,"");
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public boolean isAce() {
        //Este metodo
        return value == 1;  //Valora si es un AS o no.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && Objects.equals(suit, card.suit);
    }

    @Override
    public String toString() {
        String cardValue;
        switch (value) {
            case 1:
                cardValue = "A";
                break;
            case 11:
                cardValue = "J";
                break;
            case 12:
                cardValue = "Q";
                break;
            case 13:
                cardValue = "K";
                break;
            default:
                cardValue = String.valueOf(value);
                break;
        }
    //Lo unico que hace es pasar el String del palo a un simbolo, para que sea mas estetico.
    String suitSymbol;
        switch (suit) {
        case "Corazones":
            suitSymbol = "♥";
            break;
        case "Diamantes":
            suitSymbol = "♦";
            break;
        case "Tréboles":
            suitSymbol = "♣";
            break;
        case "Picas":
            suitSymbol = "♠";
            break;
        default:
            suitSymbol = suit;
            break;
    }

    return
            "┌───────┐\n" +
            "| " + cardValue + "     |\n" +
            "|       |\n" +
            "|   " + suitSymbol + "   |\n" +
            "|       |\n" +
            "|     " + cardValue + " |\n" +
            "└───────┘";
}
}