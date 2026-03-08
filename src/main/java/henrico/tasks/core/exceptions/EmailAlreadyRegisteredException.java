package henrico.tasks.core.exceptions;

public class EmailAlreadyRegisteredException extends RuntimeException {

    private String wrongEmail;

    public EmailAlreadyRegisteredException(String message, String wrongEmail) {
        super(message);
        this.wrongEmail = wrongEmail;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public void setWrongEmail(String wrongEmail) {
        this.wrongEmail = wrongEmail;
    }

}
