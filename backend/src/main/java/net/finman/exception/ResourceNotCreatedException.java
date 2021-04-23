package net.finman.exception;

public class ResourceNotCreatedException extends Exception {
    private String details;

    public ResourceNotCreatedException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
