package main.java.exceptions;

public class NotLogInException extends RuntimeException {
    public NotLogInException() {
        super("Ошибка входа. Для дальнейшего совершения операции выполните вход.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
