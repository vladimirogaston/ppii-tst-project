package view;

import controller.ApplicationController;
import model.CommandExecutor;

public class ApplicationView {

    private static final String prompt = "APP::";
    private String input;
    private IO io;
    private ApplicationController controller;

    public ApplicationView(CommandExecutor commandExecutor) {
        this.controller = new ApplicationController(this, commandExecutor);
        this.io = new IO();
        this.input = "";
    }

    public void display(String message) {
        io.writeln(prompt + " " + message);
    }

    public void display() {
        this.input = io.readString(prompt);
        this.controller.actionPerformed();
    }

    public void clear() {
        input = "";
    }

    public String getInput() {
        return input;
    }
}