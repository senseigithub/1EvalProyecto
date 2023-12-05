package Model;

import java.util.Collections;


public class Deck {
    //El parking es la baraja.
    public static Card [] newDeck = new Card[52];

    private static String [] suit = new String[] {"Corazones,Diamantes,Tréboles,Picas"};

    public Deck(int [] Card){
    int numeroCartas=0;
     for (int i = 1; i <= 13; i++) {
        // Añadir cada número cuatro veces a la baraja

        newDeck[numeroCartas]= new Card(i, "Corazones");
        numeroCartas++;
        newDeck[numeroCartas]= new Card(i, "Picas");
        numeroCartas++;
        newDeck[numeroCartas]= new Card(i, "Diamantes");
        numeroCartas++;
        newDeck[numeroCartas]= new Card(i, "Tréboles");
        numeroCartas++;
        }
    }

    /*
    public void mezclar() {
        Collections.shuffle(cartas);
    }
*/
}
