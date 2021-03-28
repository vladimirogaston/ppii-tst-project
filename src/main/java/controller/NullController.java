package controller;

public class NullController implements OperationController {

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }

    public String fault() {
        return "invalid operation";
    }
}
