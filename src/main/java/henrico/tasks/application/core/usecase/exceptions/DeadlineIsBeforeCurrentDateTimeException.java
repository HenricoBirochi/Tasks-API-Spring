package henrico.tasks.application.core.usecase.exceptions;

import java.time.LocalDateTime;

public class DeadlineIsBeforeCurrentDateTimeException extends RuntimeException {

    private LocalDateTime wrongDeadline;

    public DeadlineIsBeforeCurrentDateTimeException(String message, LocalDateTime wrongDeadline) {
        super(message);
        this.wrongDeadline = wrongDeadline;
    }

    public LocalDateTime getWrongDeadline() {
        return wrongDeadline;
    }

    public void setWrongDeadline(LocalDateTime wrongDeadline) {
        this.wrongDeadline = wrongDeadline;
    }

}
