package Model;

import java.util.Scanner;

public class Game {
    //Instancio el nuevo jugador, y le doy sus atributos, isDealer esta en falso ese es un jugador normal.
    private Player player = new Player("Adrián", 0, 0, false);
    //Instancio el croupier, y le doy nombre. Y pongo el boleano en verdadero.
    private Player dealer = new Player("Ramon Dino", 0, 0, true);
    //Creo un nuevo objeto que es la baraja, dentro de esta clase.
    private Deck deck = new Deck();

    //Este es el Run que es donde va la ejecución del programa.
    public void run() {
        // Repartir las cartas iniciales
        player.addToHand(deck.drawCard());
        dealer.addToHand(deck.drawCard());
        player.addToHand(deck.drawCard());
        dealer.addToHand(deck.drawCard());

        // Mostrar las cartas del croupier
        System.out.println("Mano del dealer o croupier:");
        dealer.printHand();

        // Turno del jugador
        playerTurn(player, deck);

        // Turno del dealer
        dealerTurn(dealer, deck);

        // Determinar el ganador
        determineWinner(player, dealer);
    }

    private static void playerTurn(Player player, Deck deck) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;


        while (valid) {
            System.out.println("Mano del jugador:");
            player.printHand(); // Mostrar las cartas del jugador

            //Una vez imprimidas, las cartas del croupier el jugador, anteriormente a visto su mano.
            //Procede a meter en elección y ponerlo en minuscula lo que introduzca el usuario.
            System.out.println("¿Quieres otra carta? (escribe 's' para sí, 'n' para no): ");
            String choice = scanner.nextLine().toLowerCase();

            if ("s".equals(choice)) {
                //Si el jugador elige coger otra carta, añade una carta a la mano del jugador.
                player.addToHand(deck.drawCard());

                if (player.getHandValue() > 21) {
                    //Si cuando el jugador coge otra carta se pasa de los 21 puntos. Pierde.
                    System.out.println("Te has pasado de 21. ¡Perdiste!");
                    valid=false;
                }
            } else if ("n".equals(choice)) {
                //Si eliges NO se sale
                valid=false;
            } else {
                //Si ponen algo que no sea si o no, te pone que lo tienes que volver a introducir.
                System.out.println("Por favor, introduce 's' o 'n'.");
            }
        }

        //Muestra la mano final del jugador pongas si o no da igual.
        System.out.println("Tu mano final:");
        player.printHand();
    }

    private static void dealerTurn(Player dealer, Deck deck) {
        //Es el turno del croupier.
        System.out.println("Turno del dealer:");

        while (dealer.getHandValue() < 17) {
            //Mientras los puntos totales de la mano del croupier sean menores que 17, añade obligatoriamente una carta.
            dealer.addToHand(deck.drawCard());
        }

        dealer.printHand(); // Mostrar la mano final del dealer.

        if (dealer.getHandValue() > 21) {
            System.out.println("El dealer se ha pasado de 21. ¡Ganas!");
        }
    }

    private static void determineWinner(Player player, Player dealer) {
        //Esta función determina el ganador del juego.
        //Coge el valor total de la mano del jugador y lo mete en un entero.
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        //Imprime la puntuación de cada uno.
        System.out.println("Jugador: " + playerValue);
        System.out.println("Dealer: " + dealerValue);

        //Si el valor del jugador y el croupier es mayor los dos que 21 pues es un empate.
        if (playerValue > 21 && dealerValue > 21) {
            System.out.println("Ambos jugadores se han pasado de 21. ¡Es un empate!");
        } else if (playerValue > 21) {
            System.out.println("Te has pasado de 21. ¡Pierdes!");
        } else if (dealerValue > 21) {
            System.out.println("El dealer se ha pasado de 21. ¡Ganas!");
        } else if (playerValue > dealerValue) {
            System.out.println("¡Ganas!");
        } else if (dealerValue > playerValue) {
            System.out.println("¡Pierdes!");
        } else {
            System.out.println("Empate");
        }
    }
}


