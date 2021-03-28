package view;

import controller.RemoveController;

public class RemoveView {

    public void interact(RemoveController controller) {
        IO io = new IO();
        String nombre = io.readString("RM:: ");
        controller.remove(nombre);
    }
}
