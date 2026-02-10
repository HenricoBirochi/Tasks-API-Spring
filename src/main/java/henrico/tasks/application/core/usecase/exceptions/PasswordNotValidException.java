package henrico.tasks.application.core.usecase.exceptions;

public class PasswordNotValidException extends RuntimeException {

    public PasswordNotValidException(String message) {
        super(message);
    }
}
