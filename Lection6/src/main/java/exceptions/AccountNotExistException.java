package main.java.exceptions;

public class AccountNotExistException extends RuntimeException{
    public AccountNotExistException(){
        super("Счета с таким номером не существует. Проверьте правильность введения номера.");
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
