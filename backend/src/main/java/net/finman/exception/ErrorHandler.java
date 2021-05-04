package net.finman.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNotCreatedException.class)
    public ResponseEntity<?> resourceNotCreatedException(ResourceNotCreatedException e) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), e.getDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), e.getDetails()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotDeletedException.class)
    public ResponseEntity<?> resourceNotDeletedException(ResourceNotDeletedException e) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), e.getDetails()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotUpdatedException.class)
    public ResponseEntity<?> resourceNotUpdatedException(ResourceNotUpdatedException e) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), e.getDetails()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmailNotSentException.class)
    public ResponseEntity<?> emailNotSendException(EmailNotSentException e) {
        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage(), e.getDetails()), HttpStatus.BAD_REQUEST);
    }
}
