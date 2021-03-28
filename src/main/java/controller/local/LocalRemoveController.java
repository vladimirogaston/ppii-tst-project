package controller.local;

import controller.OperationController;
import controller.OperationControllerVisitor;
import controller.RemoveController;
import model.Agenda;
import model.Persona;

public class LocalRemoveController implements OperationController, RemoveController {

    private Agenda agenda;

    public LocalRemoveController(Agenda agenda){
        this.agenda = agenda;
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void remove(String nombre) {
        agenda.remove(nombre);
    }
}