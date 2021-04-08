package system_boundary;

public class ExecutionException extends RuntimeException {

    public static String message = "Execution exception: ";

    public ExecutionException(String detail) {
        super(message + " " + detail);
    }
}
