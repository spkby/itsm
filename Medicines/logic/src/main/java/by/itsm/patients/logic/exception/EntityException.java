package by.itsm.patients.logic.exception;

public class EntityException extends BusinessException {

    public EntityException(String message) {
        super(message);
    }

    public EntityException(RuntimeException exception) {
        super(exception);
    }

    public EntityException(RuntimeException exception, String message) {
        super(exception, message);
    }
}
