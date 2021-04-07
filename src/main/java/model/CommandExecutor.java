package model;

import model.peripheral.CommandCreator;

import java.util.*;
import java.util.stream.Collectors;

public class CommandExecutor {

    private Map<String, Map<String, Command>> commandMap;

    public CommandExecutor(List<CommandCreator> creators) {
        commandMap = new HashMap<>();
        creators.forEach(creator -> {
            commandMap.put(creator.getPeripheralName(), creator.makeCommands());
        });
    }

    public void execute(String inputCommand) {
        List<String> lst = Collections.list(new StringTokenizer(inputCommand, "::"))
                .stream().map(token -> (String) token).collect(Collectors.toList());
        if(lst.size() == 2) {
            String peripheral = lst.get(1);
            if(!commandMap.containsKey(lst.get(1))){
                throw new InvalidCommandException(inputCommand + " Peripheral not found.");
            } else {
                Map<String, Command> peripheralCommands = commandMap.get(peripheral);
                String paramCommand = lst.get(0);
                if(!peripheralCommands.containsKey(paramCommand)) {
                    throw new InvalidCommandException(inputCommand + " Command not found");
                } else {
                    Command command = peripheralCommands.get(paramCommand);
                    command.execute();
                }
            }
        }
    }
}