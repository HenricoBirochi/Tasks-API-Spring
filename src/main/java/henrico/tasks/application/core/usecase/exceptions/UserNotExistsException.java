package henrico.tasks.application.core.usecase.exceptions;

public class UserNotExistsException extends RuntimeException {

    public UserNotExistsException(String message) {
        super(message);
    }
}
