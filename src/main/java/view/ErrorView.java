package view;

import controller.NullController;

public class ErrorView {

    private static final String TERM = "ERR:: ";

    public ErrorView() {
    }

    public void interact(NullController nullController) {
        new IO().writeln(TERM + nullController.fault());
    }
}
