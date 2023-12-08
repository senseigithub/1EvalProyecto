package Controller;

import View.Menu;

import java.util.Scanner;

public class MainController {
    Menu menu= new Menu();
    int opcion=valid();

    public void run(){
        menu.mainMenu();
    }

    public int valid(){
        //Este metodo va a validar las opciones introducidas por el usuario
        Scanner teclado = new Scanner(System.in);
        int opcion=teclado.nextInt();
        boolean valid = true;

        do {
            try {
                opcion = teclado.nextInt();
                valid = false;
            } catch (Exception e){
                System.out.println("Pon los valores correctamente");
                teclado.nextLine();
            }

        } while (opcion<1 || opcion>4);
        return opcion;
    }

    public void chooseOpcion(int opcion){
        //Este metodo va a recibir la opcion validada para hacer el switch
        switch (opcion){
            case 1:

                break;
            case 2:

                break;
        }
    }
}
