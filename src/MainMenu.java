import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private MenuOption[] availableOptions;
    // Внутренний класс для представления пункта меню
    private static class MenuOption {
        String description;
        MenuOption(String description) {
            this.description = description;
        }
        @Override
        public String toString() {
            return description;
        }
    }
    public MainMenu() {
        availableOptions = new MenuOption[5]; // Фиксированный размер массива
        addOptions();
    }
    private void addOptions() {
        availableOptions[0] = new MenuOption("1-Детское");
        availableOptions[1] = new MenuOption("2-Детективы");
        availableOptions[2] = new MenuOption("3-Комедии");
        availableOptions[3] = new MenuOption("4-Мелодрамы");
        availableOptions[4] = new MenuOption("5-Сериалы");
    }

    public int chooseOptions() {
        Scanner scanner = new Scanner(System.in);
        int genre = 0;

        System.out.println("Доступные направления видео:");
        for (int i = 0; i < availableOptions.length; i++) {
            System.out.println(availableOptions[i]);
        }

        System.out.print("Выберите желаемое направление (1-" + availableOptions.length + "): ");
        while (true) {
            if (scanner.hasNextInt()) {
                genre = scanner.nextInt();
                if (genre >= 1 && genre <= availableOptions.length) {
                    break;
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите число от 1 до " + availableOptions.length + ".");
                    scanner.next();
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите число.");
                scanner.next();
            }
        }
        return genre;
    }
}