package exceptions;

public class NotCcorrectAmountException extends Throwable {
    public NotCcorrectAmountException() {
        super("Перевод невозможен. Сумма перевода должна быть кратна 100. Попробуйте снова.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
