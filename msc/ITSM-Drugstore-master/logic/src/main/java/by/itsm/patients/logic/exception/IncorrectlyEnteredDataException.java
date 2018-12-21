package by.itsm.patients.logic.exception;

public class IncorrectlyEnteredDataException extends BusinessException {
    public IncorrectlyEnteredDataException(String message) {
        super(message);
    }

    public IncorrectlyEnteredDataException(RuntimeException exception) {
        super(exception);
    }

    public IncorrectlyEnteredDataException(RuntimeException exception, String message) {
        super(exception, message);
    }
}
