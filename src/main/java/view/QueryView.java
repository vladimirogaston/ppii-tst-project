package view;

import controller.QueryController;

public class QueryView {

    private static final String TERM = "QUERY:: ";
    private static final String EMPTY = "empty record set";

    public QueryView() {}

    public void interact(QueryController queryController) {
        IO io = new IO();
        if(queryController.read().isEmpty()) {
            io.writeln(TERM + EMPTY);
        } else {
            queryController.read().forEach(p -> {
                io.writeln(TERM + p.toString());
            });
        }
    }
}