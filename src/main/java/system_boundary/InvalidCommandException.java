package system_boundary;

public class InvalidCommandException extends RuntimeException {

    private static final String message = "Invalid command: ";

    public InvalidCommandException(String detail) {
        super(message + " " + detail);
    }
}
