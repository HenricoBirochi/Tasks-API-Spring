package henrico.tasks.application.core.usecase.task.exceptions;

public class DeadlineIsBeforeCurrentDateTimeException extends RuntimeException {
    public DeadlineIsBeforeCurrentDateTimeException(String message) {
        super(message);
    }
}
