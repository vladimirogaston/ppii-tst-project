package view;

public class StartView {

    private String message = ">> ConsoleAgenda v1.0";
    private String time = ">> Initiaized at: ";

    public StartView() {
    }

    public void interact(StartController startController) {
        IO io = new IO();
        io.writeln(message);
        io.writeln(time + startController.getTime());
    }
}
