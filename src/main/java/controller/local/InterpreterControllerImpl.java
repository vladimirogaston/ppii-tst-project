package controller.local;

import controller.*;
import model.Agenda;

import java.util.HashMap;
import java.util.Map;

public class InterpreterControllerImpl implements InterpreterController {

    private Map<String, OperationController> controllers;
    private Agenda agenda;

    public InterpreterControllerImpl() {
        this.agenda = new Agenda();
        this.controllers = new HashMap<String, OperationController>();
        this.controllers.put("add -> p:", new LocalAddController(agenda));
        this.controllers.put("lst -> p:", new LocalQueryController(agenda));
        this.controllers.put("rem -> p:", new LocalRemoveController(agenda));
    }

    @Override
    public boolean validate(String command) {
        return this.controllers.containsKey(command);
    }

    @Override
    public OperationController getController(String operation) {
        OperationController controller = null;
        if(this.controllers.containsKey(operation)) {
            controller = this.controllers.get(operation);
        } else {
            controller = new NullController();
        }
        return controller;
    }
}