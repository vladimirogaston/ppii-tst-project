import model.CommandExecutor;
import model.peripheral.AirConditionerCommandsCreator;
import model.peripheral.CommandCreator;
import model.peripheral.RadioCommandsCreator;
import view.ApplicationView;

import java.util.LinkedList;

public class Application {

    CommandExecutor commandExecutor;
    ApplicationView view;

    private LinkedList<CommandCreator> makeCommandCreator() {
        AirConditionerCommandsCreator acCommandCreator = new AirConditionerCommandsCreator();
        RadioCommandsCreator radioCommandsCreator = new RadioCommandsCreator();
        LinkedList<CommandCreator> commandCreatorList = new LinkedList<>();
        commandCreatorList.add(acCommandCreator);
        commandCreatorList.add(radioCommandsCreator);
        return commandCreatorList;
    }

    public Application() {
        LinkedList<CommandCreator> creators = makeCommandCreator();
        commandExecutor = new CommandExecutor(creators);
        view = new ApplicationView(commandExecutor);
        creators.forEach(creator -> creator.attachObserver(view));
    }

    public void run() {
        do {
            view.display();
        } while (true);
    }

    public static void main(String [] args) {
        new Application().run();
    }
}