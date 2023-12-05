package Model;

public class Card {
    //La baraja son los coches.
    private int valor;

    private String palo;
    public Car(int valor, String palo){
        this.valor= valor;
        this.palo= palo;
    }
    public Card(){ this(1,"");
    }

    public int getValor() {
        return valor;
    }

    public String getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
