package system_boundary;

import model.Observer;
import system_boundary.Command;

import java.util.Map;

public interface CommandCreator {

    Map<String, Command> makeCommands();

    String getPeripheralName();

    void attachObserver(Observer observer);
}
