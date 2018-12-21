package by.itsm.patients.logic.exception;

public class BusinessException extends RuntimeException {

    protected RuntimeException exception;

    protected String message;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(RuntimeException exception) {
        this.exception = exception;
    }

    public BusinessException(RuntimeException exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public RuntimeException getException() {
        return exception;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return /*exception + "|" + */message;
    }


}
