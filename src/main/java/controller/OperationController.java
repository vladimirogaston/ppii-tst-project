package controller;

public interface OperationController {

    void accept(OperationControllerVisitor visitor);
}
