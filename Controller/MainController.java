package Controller;

import Model.*;

import View.Menu;

import java.util.Scanner;

public class MainController {
    private Menu menu = new Menu();
    private Game game = new Game();

    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.run();
    }

    public void run() {
        menu.mainMenu();
        int opcion = valid();
        chooseOpcion(opcion);
    }

    public int valid() {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.print("Introduce una opción: ");
                opcion = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor, introduce un valor válido.");
                teclado.nextLine(); // Limpiar el buffer del scanner
                opcion = 0; // Establecer un valor por defecto para evitar un bucle infinito
            }
        } while (opcion < 1 || opcion > 2);

        return opcion;
    }

    public void chooseOpcion(int opcion) {
        switch (opcion) {
            case 1:
                game.run();
                break;
            case 2:
                // Agrega el código correspondiente para la opción 2
                break;
        }
    }
}
