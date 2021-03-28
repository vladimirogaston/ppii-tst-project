import controller.InterpreterController;
import controller.local.InterpreterControllerImpl;
import view.AgendaView;

public class Agenda {

    AgendaView view = new AgendaView();
    InterpreterController interpreter = new InterpreterControllerImpl();

    public void run() {
        do {
            String operation = view.print();
            view.interact(interpreter.getController(operation));
        } while (true);
    }

    public static void main(String [] args) {
        new Agenda().run();
    }
}