import controller.InterpreterController;
import controller.OperationController;
import controller.local.InterpreterControllerImpl;
import view.AgendaView;

public class Aplicacion {

    AgendaView view = new AgendaView();
    InterpreterController logic = new InterpreterControllerImpl();

    public void run() {
        do {
            String operation = view.print();
            OperationController controller = logic.getController(operation);
            view.interact(controller);
        } while (true);
    }

    public static void main(String [] args) {
        new Aplicacion().run();
    }

    // US-01: Control de periferico por comando
    // Como tunueador quiero contralar un periferico del auto ingresando un comando para no interactuar
    // con la interfaz física del automotor.
    // UAT-01: Happy path
    // Input: lock-d -> 3
    // output: "msg: door nr. 3 lock"
    // UAT-02: Comando inex.
    // Input: lock-h -> 1
    // output: "msg: comando inexistente"
    // UAT-03: Comando existente/parametro inválido
    // input: lock-d -> 7
    // output: "msg: parametro inválido"

    // US-2: Añadir comando y periférico
    // Como registrador puedo añadir un nuevo comando y asociarlo a un perferico nuevo para extender
    // las posibilidades de controlar el vehículo.
    // UAT-01: Happy path
    // Input: Agrega comando lock-v : 1 y el periferico Ventana
    // output:
}