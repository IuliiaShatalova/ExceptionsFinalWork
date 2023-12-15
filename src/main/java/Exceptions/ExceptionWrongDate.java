package Exceptions;

public class ExceptionWrongDate extends RuntimeException {
    public ExceptionWrongDate(){
        super("Дата введена неверно");
    }
}
