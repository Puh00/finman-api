package net.finman.exception;

public class ResourceNotFoundException extends Exception {
    private String details;

    public ResourceNotFoundException(String message) {
        this(message, "No details were provided");
    }

    public ResourceNotFoundException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
