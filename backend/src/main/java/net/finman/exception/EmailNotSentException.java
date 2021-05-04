package net.finman.exception;

public class EmailNotSentException extends Exception {
    private String details;

    public EmailNotSentException(String message, String details) {
        super(message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}
