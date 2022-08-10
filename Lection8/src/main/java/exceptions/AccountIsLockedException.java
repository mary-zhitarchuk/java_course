package exceptions;

public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException(int lockTime)
    {
        super("Превышено количество попыток ввода пин-кода. Счет заблокирован. Попробуйте снова через " + lockTime + " сек");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
