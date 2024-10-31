import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu
{
    private ArrayList<String> availableOptions;

    public MainMenu() {
        availableOptions = new ArrayList<>();
        addOptions();
    }

    private void addOptions() {
        availableOptions.add("1-Детское ");
        availableOptions.add("2-Детективы");
        availableOptions.add("3-Комедии");
        availableOptions.add("4-Мелодрамы");
        availableOptions.add("5-Сериалы");
    }
    public int chooseOptions() {
        Scanner scanner = new Scanner(System.in);
        int genre = 0;

        System.out.println("Доступные направления видео:");
        for (int i = 0; i < availableOptions.size(); i++) {
            System.out.println(availableOptions.get(i));
        }

        System.out.print("Выберите желаемое направление (1-5): ");
        while (true) {
            if (scanner.hasNextInt()) {
                genre = scanner.nextInt();
                if (genre >= 1 && genre <= availableOptions.size()) {
                    break; // Выход из цикла, если ввод корректный
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите число от 1 до " + availableOptions.size() + ".");
                    scanner.next(); // Очистка буфера
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите число.");
                scanner.next(); // Очистка буфера
            }
        }
        return genre;
}
}
