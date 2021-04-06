import model.CommandExecutor;
import view.ApplicationView;

public class Application {

    private CommandExecutor commandExecutor = new CommandExecutor();
    private ApplicationView view = new ApplicationView(commandExecutor);

    public void run() {
        do {
            view.display();
        } while (true);
    }

    public static void main(String [] args) {
        new Application().run();
    }
}
