package lk.ijse.possystembackendwithspring.exeption;

public class DataPersistException extends RuntimeException{
    public DataPersistException() {
        super();
    }

    public DataPersistException(String message) {
        super(message);
    }
    public DataPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}
