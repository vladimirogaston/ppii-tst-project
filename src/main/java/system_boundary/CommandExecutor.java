package system_boundary;

import java.util.*;
import java.util.stream.Collectors;

public class CommandExecutor {

    private static final String PARAMS_EXCEPTION = "Invalid number of parameters.";
    private static final String PERIPHERAL_NOT_FOUND = "Peripheral not found.";
    private static final String COMMAND_NOT_FOUND = "Command not found.";
    private Map<String, Map<String, Command>> commandMap;

    public CommandExecutor(List<CommandCreator> creators) {
        commandMap = new HashMap<>();
        creators.forEach(creator -> {
            commandMap.put(creator.getPeripheralName(), creator.makeCommands());
        });
    }

    public void execute(String inputCommand) {
        List<String> params = Collections.list(new StringTokenizer(inputCommand, "::"))
                .stream().map(token -> (String) token).collect(Collectors.toList());
        if(params.size() != 2) {
          throw new IllegalArgumentException(PARAMS_EXCEPTION);
        } else {
            final String paramPeripheral = params.get(1);
            if(!commandMap.containsKey(params.get(1))){
                throw new InvalidCommandException(paramPeripheral + " " + PERIPHERAL_NOT_FOUND);
            } else {
                Map<String, Command> peripheralCommands = commandMap.get(paramPeripheral);
                final String paramCommand = params.get(0);
                if(!peripheralCommands.containsKey(paramCommand)) {
                    throw new InvalidCommandException(inputCommand + " " + COMMAND_NOT_FOUND);
                } else {
                    Command command = peripheralCommands.get(paramCommand);
                    command.execute();
                }
            }
        }
    }
}