package by.itsm.patients.logic.exception;

public class NotFoundException extends BusinessException {


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(RuntimeException exception) {
        super(exception);
    }

    public NotFoundException(RuntimeException exception, String message) {
        super(exception, message);
    }
}
