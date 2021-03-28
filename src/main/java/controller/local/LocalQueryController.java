package controller.local;

import controller.OperationController;
import controller.OperationControllerVisitor;
import controller.QueryController;
import model.Agenda;
import model.Persona;

import java.util.Set;

public class LocalQueryController implements OperationController, QueryController {

    private Agenda agenda;

    public LocalQueryController(Agenda agenda){
        this.agenda = agenda;
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Set<Persona> read() {
        return agenda.readAll();
    }
}