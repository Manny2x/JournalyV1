package data.exceptions;

public class AccountNotFoundException extends Exception{
    private final String cause;

    public AccountNotFoundException(String cause){
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "Profile was not found because: " +
                cause;
    }
    public String getCauseValue() {
        return cause;
    }
}
