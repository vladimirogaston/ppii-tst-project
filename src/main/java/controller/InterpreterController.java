package controller;

public interface InterpreterController {

    boolean validate(String operation);

    OperationController getController(String operation);
}