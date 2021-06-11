package net.finman.exception;

public class ResourceNotDeletedException extends Exception {

    private final String details;

    public ResourceNotDeletedException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
