package Model;

import java.util.Collections;
import java.util.List;


public class Deck {
    //El parking es la baraja.
    static int numeroCartas=0;
    public static Card [] deck = new Card[52]; //Arreglo de cartas con las 52 cartas.

    private static String [] suit = new String[] {"Corazones,Diamantes,Tréboles,Picas"}; //Arreglo de las pintas.

    /**
     * Este clase lo que hace es recorrer la baraja, y asignar los números cuatro veces, luego les asigna el palo
     * y los baraja.
     */
    public Deck(){
     for (int i = 1; i <= 13; i++) {
        // Añadir cada número cuatro veces a la baraja

        deck[numeroCartas]= new Card(i, "Corazones");
        numeroCartas++;
        deck[numeroCartas]= new Card(i, "Picas");
        numeroCartas++;
        deck[numeroCartas]= new Card(i, "Diamantes");
        numeroCartas++;
        deck[numeroCartas]= new Card(i, "Tréboles");
        numeroCartas++;
        }
     mezclar(); //Las baraja despues de crearlas.
    }

    @Override
    public String toString() {
        for (int i= 0;i<= deck.length;i++){
            System.out.println(deck[i]);
        }
        return super.toString();
    }


    private void mezclar() {
        //La clase Collections es la que nos dara el metodo empleado
        Collections.shuffle(List.of(deck));
    }

    public static Card[] getDeck() {
        if (numeroCartas==51){
            System.out.println("No hay que repartir más cartas");
            return null;
        }
        return null;
    }
}
