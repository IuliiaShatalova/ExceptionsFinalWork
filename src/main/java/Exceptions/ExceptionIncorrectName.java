package Exceptions;

public class ExceptionIncorrectName extends RuntimeException {
    public ExceptionIncorrectName(){
        super("Имя/Фамилия/Отчество введено неверно");
    }
}
