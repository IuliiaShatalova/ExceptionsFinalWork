package Exceptions;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        UI ui = new UI(model);
        ui.start();
    }
}
