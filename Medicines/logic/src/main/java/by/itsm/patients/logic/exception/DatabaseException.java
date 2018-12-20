package by.itsm.patients.logic.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(RuntimeException exception) {
        super(exception);
    }

}
