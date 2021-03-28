package view;

import controller.InterpreterController;

public class InputView {

    private final String TERM = "app:: ";
    private final String INVALID = "Invalid command";

    public InputView() {
    }

    public String print() {
        IO io = new IO();
        String command = "";
        do {
            command = io.readString("TERM:: ");
        }while(command.trim().isEmpty());
        return command;
    }
}