package Exceptions;

public class ExceptionExtraData extends RuntimeException {
    public ExceptionExtraData() {
        super("Вы ввели лишние данные");
    }
}
