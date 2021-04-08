import system_boundary.AppCommandCreator;
import system_boundary.CommandExecutor;
import system_boundary.CommandCreator;
import view.ApplicationView;

import java.util.List;

public class Application {

    CommandExecutor commandExecutor;
    ApplicationView view;
    List<CommandCreator> creators;

    public Application() {
        init();
    }

    private void init() {
        creators = new AppCommandCreator().makeCommandCreator();
        commandExecutor = new CommandExecutor(creators);
        view = new ApplicationView(commandExecutor);
        attachObservers();
    }

    private void attachObservers() {
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