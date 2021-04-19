package net.finman.exception;

import java.util.Date;

public class ErrorDetails {
    private final Date date;
    private final String message;
    private final String details;

    public ErrorDetails(Date date, String message, String details) {
        this.date = date;
        this.message = message;
        this.details = details;
    }
}
