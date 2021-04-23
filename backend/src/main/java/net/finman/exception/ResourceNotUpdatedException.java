package net.finman.exception;

public class ResourceNotUpdatedException extends Exception {
    private String details;

    public ResourceNotUpdatedException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
