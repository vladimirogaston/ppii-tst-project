package controller;

import model.CommandExecutor;
import model.ExecutionException;
import model.InvalidCommandException;
import view.ApplicationView;

public class ApplicationController {

    private static final String EXECUTION_OK = "command execution satus [OK]";

    private static final String EXECUTION_FAIL = "command execution status [fails]";

    private ApplicationView view;

    private CommandExecutor commandExecutor;

    public ApplicationController(ApplicationView applicationView, CommandExecutor commandExecutor) {
        this.view = applicationView;
        this.commandExecutor = commandExecutor;
    }

    public void actionPerformed() {
        String input = view.getInput();
        try {
            commandExecutor.execute(input);
            view.clear();
            view.display(EXECUTION_OK);
        } catch(InvalidCommandException | ExecutionException exception) {
            view.display(EXECUTION_FAIL + " " + exception.getMessage());
        }
    }
}