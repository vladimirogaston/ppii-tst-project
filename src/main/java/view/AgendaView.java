package view;

import controller.*;

public class AgendaView implements OperationControllerVisitor {

    public AgendaView() {
    }

    public void interact(OperationController controller) {
        controller.accept(this);
    }

    @Override
    public void visit(QueryController queryController) {
        new QueryView().interact(queryController);
    }

    @Override
    public void visit(AddController addController) {
        new AddView().interact(addController);
    }

    @Override
    public void visit(NullController nullController) {
        new ErrorView().interact(nullController);
    }

    @Override
    public void visit(RemoveController removeController) {
        new RemoveView().interact(removeController);
    }

    public String print() {
        return new InputView().print();
    }
}