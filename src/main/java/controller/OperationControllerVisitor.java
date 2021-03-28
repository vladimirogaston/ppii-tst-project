package controller;

public interface OperationControllerVisitor {

    void visit(QueryController queryController);

    void visit(AddController addController);

    void visit(NullController nullController);

    void visit(RemoveController removeController);
}
