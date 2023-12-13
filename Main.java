import Controller.MainController;
import Model.Game;
import View.Menu;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        Menu menu = new Menu();
        menu.mainMenu(); // Llama al menu que he creado en la vista.

        int opcion = controller.valid(); // Usa la validación que he hecho en el mainController y la mete en el entero.
        controller.chooseOpcion(opcion); // Usa el metodo creado en el mainController.
    }
}