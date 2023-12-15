package Exceptions;

public class ExceptionLackOfData extends RuntimeException {
    public ExceptionLackOfData(){
        super("Вы ввели недостаточно данных");
    }
}
