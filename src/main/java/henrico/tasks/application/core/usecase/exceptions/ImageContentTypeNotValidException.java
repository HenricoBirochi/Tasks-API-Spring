package henrico.tasks.application.core.usecase.exceptions;

public class ImageContentTypeNotValidException extends RuntimeException {

    private String wrongContentType;

    public ImageContentTypeNotValidException(String message, String wrongContentType) {
        super(message);
        this.wrongContentType = wrongContentType;
    }

    public String getWrongContentType() {
        return wrongContentType;
    }

    public void setWrongContentType(String wrongContentType) {
        this.wrongContentType = wrongContentType;
    }

}
