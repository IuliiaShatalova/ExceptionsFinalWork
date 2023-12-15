package Exceptions;

import java.time.format.DateTimeParseException;

public class UI {
    private Model model;

    public UI(Model model) {
        this.model = model;
    }

    public void start(){
        while (true) {
            System.out.println("Введите данные в формате:\nФамилия Имя Отчество " +
                    "\ndd.mm.yyyy (дата рождения) \n88888888888 (номер телефона) " +
                    "\nm (пол, f или m)");
            try {
                Person person = model.checkData(model.getUserInfo());
                model.checkName(person.getSurname());
                model.checkName(person.getName());
                model.checkName(person.getPatronymic());
                model.checkBirthday(person.getBirthday());
                model.checkPhoneNumber(person.getPhoneNumber());
                model.checkGender(person.getGender());
                model.fileWriter(person);
                break;
            } catch (ExceptionExtraData e) {
                System.out.println("Вы ввели лишние данные");
                continue;
            } catch (ExceptionLackOfData e) {
                System.out.println("Вы ввели недостаточно данных");
                continue;
            } catch (ExceptionIncorrectName e) {
                System.out.println("Имя/Фамилия/Отчество введено неверно");
                continue;
            } catch (DateTimeParseException e) {
                System.out.println("Дата введена неверно, проферте формат ввода");
                continue;
            } catch (ExceptionWrongDate e) {
                System.out.println("Дата введена неверно");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("Номер телефона введен неверно");
                continue;
            } catch (ExceptionIncorrectGender e) {
                System.out.println("Вы допустили ошибку в записи пола");
                continue;
            }
        }
    }
}
