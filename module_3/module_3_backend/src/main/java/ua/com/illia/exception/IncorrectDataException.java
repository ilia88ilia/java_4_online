package ua.com.illia.exception;

public class IncorrectDataException extends SecurityException {
    public IncorrectDataException(String text) {
        super(text);
    }
}
