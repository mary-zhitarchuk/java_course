package exceptions;

public class NotValidPinException extends RuntimeException {
    public NotValidPinException(int numberOfInvalidPins) {
        super("Неверный пинкод. Попробуйте снова. Количество оставшихся попыток: " + numberOfInvalidPins);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
