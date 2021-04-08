package system_boundary;

import java.util.LinkedList;
import java.util.List;

public class AppCommandCreator {

    public AppCommandCreator() {}

    public List<CommandCreator> makeCommandCreator() {
        AirConditionerCommandsCreator acCommandCreator = new AirConditionerCommandsCreator();
        RadioCommandsCreator radioCommandsCreator = new RadioCommandsCreator();
        LinkedList<CommandCreator> commandCreatorList = new LinkedList<>();
        commandCreatorList.add(acCommandCreator);
        commandCreatorList.add(radioCommandsCreator);
        return commandCreatorList;
    }
}
