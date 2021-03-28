package controller.local;

import controller.AddController;
import controller.OperationController;
import controller.OperationControllerVisitor;
import model.Agenda;
import model.Persona;

public class LocalAddController implements OperationController, AddController {

    private Agenda agenda;

    public LocalAddController(Agenda agenda) {
        assert agenda != null;
        this.agenda = agenda;
    }

    @Override
    public void add(Persona persona) {
        assert persona != null;
        agenda.agregar(persona);
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }
}