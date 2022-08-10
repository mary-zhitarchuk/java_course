package exceptions;

public class NotEnoughMoneyOnAccountException extends  RuntimeException{
    public NotEnoughMoneyOnAccountException(){
        super("Перевод совершить невозможно, недостаточно средств.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
