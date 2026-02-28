package henrico.tasks.application.core.usecase.exceptions;

public class PasswordNotValidException extends RuntimeException {

    private String wrongPassword;

    public PasswordNotValidException(String message, String wrongPassword) {
        super(message);
        this.wrongPassword = wrongPassword;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public void setWrongPassword(String wrongPassword) {
        this.wrongPassword = wrongPassword;
    }

}
