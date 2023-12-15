package Exceptions;

public class ExceptionIncorrectGender extends RuntimeException {
    public ExceptionIncorrectGender() {
        super("Вы допустили ошибку в записи пола");
    }
}
