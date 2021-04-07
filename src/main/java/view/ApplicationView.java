package view;

import model.CommandExecutor;
import model.peripheral.Observer;

public class ApplicationView implements Observer {

    private static final String prompt = "APP::";
    private String input;
    private IO io;
    private ApplicationController controller;

    public ApplicationView(CommandExecutor commandExecutor) {
        controller = new ApplicationController(this, commandExecutor);
        io = new IO();
        clear();
    }

    public void display(String message) {
        io.writeln(prompt + " " + message);
    }

    public void display() {
        input = io.readString(prompt);
        controller.actionPerformed();
    }

    public void clear() {
        input = "";
    }

    public String getInput() {
        return input;
    }

    @Override
    public void update(Object object) {
        io.writeln(prompt + "peripheral new state: " + object.toString());
    }
}