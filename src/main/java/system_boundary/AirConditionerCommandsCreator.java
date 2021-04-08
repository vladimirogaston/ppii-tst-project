package system_boundary;

import model.AirConditioner;
import model.Observer;

import java.util.HashMap;
import java.util.Map;

public class AirConditionerCommandsCreator implements CommandCreator {

    private static AirConditioner airConditioner;

    public AirConditionerCommandsCreator() {
        airConditioner = new AirConditioner();
    }

    @Override
    public Map<String, Command> makeCommands() {
        Map<String, Command> ret = new HashMap<>();
        ret.put("turnOn", new Command(){
            @Override
            public void execute() throws ExecutionException {
                airConditioner.turnOn();
            }
        });
        ret.put("turnOff", new Command(){
            @Override
            public void execute() throws ExecutionException {
                airConditioner.turnOff();
            }
        });
        ret.put("upTemperature", new Command() {
            @Override
            public void execute() throws ExecutionException {
                airConditioner.upTemperature();
            }
        });
        ret.put("downTemperature", new Command() {
            @Override
            public void execute() throws ExecutionException {
                airConditioner.downTemperature();
            }
        });
        return ret;
    }

    @Override
    public void attachObserver(Observer observer) {
        if(observer != null) {
            airConditioner.add(observer);
        }
    }

    @Override
    public String getPeripheralName(){
        return "AirConditioner";
    }
}