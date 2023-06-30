package ua.com.illia.exception;

public class InvalidDataException extends SecurityException {
    public InvalidDataException(String text) {
        super(text);
    }
}
