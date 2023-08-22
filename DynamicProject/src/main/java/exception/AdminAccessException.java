package exception;

public class AdminAccessException extends RuntimeException{
    public AdminAccessException(String message) {
        super(message);
        message = "Invalid Credentials";
    }
}
