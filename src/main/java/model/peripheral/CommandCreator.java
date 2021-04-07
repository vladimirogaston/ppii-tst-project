package model.peripheral;

import model.Command;

import java.util.Map;

public interface CommandCreator {

    Map<String, Command> makeCommands();

    String getPeripheralName();

    void attachObserver(Observer observer);
}
