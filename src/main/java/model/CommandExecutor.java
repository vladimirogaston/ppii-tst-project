package model;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private Map<String, Command> commandMap;

    public CommandExecutor() {
        this.commandMap = new HashMap<>();
        this.commandMap.putAll(new AirConditionerCommands().read());
    }

    public void execute(String inputCommand) {
        if(!commandMap.containsKey(inputCommand)){
            throw new InvalidCommandException(inputCommand + " not found.");
        }
        Command command = commandMap.get(inputCommand);
        command.execute();
    }
}