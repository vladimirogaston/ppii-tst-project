package view;

import controller.AddController;
import model.Persona;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AddView {

    private final String TERM = "ADD:: ";

    public AddView() {}

    public void interact(AddController controller) {
        IO io = new IO();
        io.write(TERM);
        String params = io.readString("");
        List<String> lst = Collections.list(new StringTokenizer(params, "/"))
                .stream().map(token->(String) token)
                .collect(Collectors.toList());
        if(params.trim().length() == 1 || lst.size() != 2) {
            io.writeln("ERROR: Invalid params");
        } else {
            Persona persona = new Persona(lst.get(0), lst.get(1));
            controller.add(persona);
            io.writeln("persona registrada");
        }
    }
}