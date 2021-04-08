package system_boundary;

import model.Observer;
import model.Radio;
import system_boundary.Command;
import system_boundary.CommandCreator;
import system_boundary.ExecutionException;

import java.util.HashMap;
import java.util.Map;

public class RadioCommandsCreator implements CommandCreator {

    private static Radio radio;

    public RadioCommandsCreator() {
        radio = new Radio();
    }

    @Override
    public void attachObserver(Observer observer) {
        if(observer != null) radio.add(observer);
    }

    @Override
    public Map<String, Command> makeCommands() {
        Map<String, Command> commandMap =  new HashMap<>();
        commandMap.put("turnOn", new Command() {
            @Override
            public void execute() throws ExecutionException {
                radio.turnOn();
            }
        });
        commandMap.put("turnOff", new Command() {
            @Override
            public void execute() throws ExecutionException {
                radio.turnOff();
            }
        });
        return commandMap;
    }

    @Override
    public String getPeripheralName() {
        return "Radio";
    }
}
