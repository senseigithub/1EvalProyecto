package Model;

import java.util.Scanner;

public class Game {
    private Player player = new Player("Adrián", 0, 0, false);
    private Player dealer = new Player("Ramon Dino", 0, 0, true);
    private Deck deck = new Deck();

    public void run() {
        // Repartir las cartas iniciales
        player.addToHand(deck.drawCard());
        dealer.addToHand(deck.drawCard());
        player.addToHand(deck.drawCard());
        dealer.addToHand(deck.drawCard());

        // Mostrar las cartas iniciales
        System.out.println("Mano del dealer o crupier:");
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

        while (true) {
            System.out.println("Mano del jugador:");
            player.printHand(); // Mostrar las cartas del jugador

            System.out.println("¿Quieres otra carta? (escribe 's' para sí, 'n' para no): ");
            String choice = scanner.nextLine().toLowerCase();

            if ("s".equals(choice)) {
                player.addToHand(deck.drawCard());

                if (player.getHandValue() > 21) {
                    System.out.println("Te has pasado de 21. ¡Perdiste!");
                    break;
                }
            } else if ("n".equals(choice)) {
                break;
            } else {
                System.out.println("Por favor, introduce 's' o 'n'.");
            }
        }

        // Mueve esta línea fuera del bucle para que se imprima una vez que el jugador haya terminado su turno.
        System.out.println("Tu mano final:");
        player.printHand();
    }

    private static void dealerTurn(Player dealer, Deck deck) {
        System.out.println("Turno del dealer:");

        while (dealer.getHandValue() < 17) {
            dealer.addToHand(deck.drawCard());
        }

        dealer.printHand(); // Mostrar la mano final del dealer

        if (dealer.getHandValue() > 21) {
            System.out.println("El dealer se ha pasado de 21. ¡Ganas!");
        }
    }

    private static void determineWinner(Player player, Player dealer) {
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("Jugador: " + playerValue);
        System.out.println("Dealer: " + dealerValue);

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


