package ua.com.illia.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.com.illia.exception.IncorrectDataException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({IncorrectDataException.class})
    public ResponseEntity<String> handleInvalidDataException(IncorrectDataException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({SecurityException.class})
    public ResponseEntity<String> handleSecurityException(SecurityException exception) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }
}
