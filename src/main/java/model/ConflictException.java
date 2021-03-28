package model;

public class ConflictException extends RuntimeException {

    private static final String message = "Conflict exception";
    public ConflictException(String detail) {
        super(message + ": " + detail);
    }
}
