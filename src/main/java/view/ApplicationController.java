package view;

import system_boundary.CommandExecutor;
import system_boundary.ExecutionException;
import system_boundary.InvalidCommandException;

public class ApplicationController {

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
        } catch(InvalidCommandException | IllegalArgumentException | ExecutionException exception) {
            view.display(EXECUTION_FAIL + " " + exception.getMessage());
        }
    }
}