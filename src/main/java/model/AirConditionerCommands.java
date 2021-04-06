package model;

import model.periferals.AirConditioner;

import java.util.HashMap;
import java.util.Map;

public class AirConditionerCommands {

    private AirConditioner airConditioner;

    private Map<String, Command> commandMap;

    public AirConditionerCommands() {
        this.airConditioner = new AirConditioner();
        this.commandMap = new HashMap<>();
        this.commandMap.put("turnOn::AirConditioner", createTurnOnCommand());
        this.commandMap.put("turOff::AirConditioner", createTurnOffCommand());
    }

    private Command createTurnOnCommand() {
        return new Command() {
            @Override
            public void execute() {
                airConditioner.turnOn();
            }
        };
    }

    private Command createTurnOffCommand() {
        return new Command() {
            @Override
            public void execute() {
                airConditioner.turnOff();
            }
        };
    }

    public Map<String, Command> read() {
        return this.commandMap;
    }
}
