package exceptions;

public class PinLengthException extends RuntimeException {
    public PinLengthException() {
        super("Пин-код должен содержать 4 символа. Попробуйте снова.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
