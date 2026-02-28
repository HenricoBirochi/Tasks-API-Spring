package henrico.tasks.application.core.usecase.exceptions;

public class UserNameAlreadyRegisteredException extends RuntimeException {

    private String wrongUserName;

    public UserNameAlreadyRegisteredException(String message, String wrongUserName) {
        super(message);
        this.wrongUserName = wrongUserName;
    }

    public String getWrongUserName() {
        return wrongUserName;
    }

    public void setWrongUserName(String wrongUserName) {
        this.wrongUserName = wrongUserName;
    }

}
