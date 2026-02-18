package henrico.tasks.application.core.usecase.exceptions;

public class ImageContentTypeNotValidException extends RuntimeException {
    public ImageContentTypeNotValidException(String message) {
        super(message);
    }
}
