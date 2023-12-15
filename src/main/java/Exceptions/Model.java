package Exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Model {
    public String getUserInfo(){
        String input = "";
        Scanner scanner = new Scanner(System.in);
        try {
            input = scanner.nextLine();
        } catch (Exception e){
            System.out.println(e.getMessage());
            scanner.close();
        }
        return input;
    }

    public Person checkData (String input) {
        int length = 6;
        String[] result = input.trim().split(" ");
        if (result.length > length) {
            throw new ExceptionExtraData();
        }
        if (result.length < length) {
            throw new ExceptionLackOfData();
        }
        return buildPerson(result);
    }

    private Person buildPerson(String[] result) {
        return new Person(result[0], result[1], result[2], result[3], result[4], result[5]);
    }

    public void checkName (String data) {
        if (!data.matches("^[а-яА-Я-]*$")) {
            throw new ExceptionIncorrectName();
        }
    }

    public void checkBirthday (String data) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        if (LocalDate.parse(data, formatter).isAfter(currentDate)){
            throw new ExceptionWrongDate();
        }
        LocalDate.parse(data, formatter);
    }

    public void checkPhoneNumber (String data) throws NumberFormatException {
        Long.parseLong(data);
    }

    public void checkGender (String data) {
        if (!data.equals("f") && !data.equals("m")) {
            throw new ExceptionIncorrectGender();
        }
    }

    public String newMark (Person person) {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s\n", person.getSurname(), person.getName(),
                person.getPatronymic(), person.getBirthday(), person.getPhoneNumber(), person.getGender());
    }

    public void fileWriter(Person person) {
        try (FileWriter writer = new FileWriter(String.format("C:\\Users\\User\\Desktop\\GB\\СПЕЦИАЛИЗАЦИЯ\\Exceptions\\exceptionsFinalWork\\src\\main\\java\\Exceptions/%s.txt", person.getSurname()), true)) {
            writer.append(newMark(person));
            System.out.println("Данные записаны");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
