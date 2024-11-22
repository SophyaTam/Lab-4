import java.util.Scanner;

public class ButtonStopAdv extends Advert {
    public ButtonStopAdv(int size) {
        super(size); // Вызов конструктора базового класса с параметром
    }

    // Конструктор без параметров
    public ButtonStopAdv() {
        this(10); // Вызов параметризованного конструктора с значением по умолчанию
    }

    // Переопределение метода chooseAdvert без вызова метода базового класса
    @Override
    public int chooseAdvert() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.print("Выберите действие: 1 - добавить рекламу, 2 - пропустить: ");
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    break; // Выходим из цикла, если ввод корректен
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите 1 или 2.");
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите целое число (1 или 2).");
                scanner.next(); // Очищаем буфер сканера от некорректного ввода
            }
        }
        return choice;
    }
    public boolean stopAdverts() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Если хотите остановить рекламу, введите \"да\" или \"нет\": ");
            input = scanner.nextLine();
            input = input.trim().toLowerCase();
            if (input.equals("да")) {
                return true;
            } else if (input.equals("нет")) {
                return false;
            } else {
                System.out.println("Ошибка: Неверный ввод. Пожалуйста, введите \"да\" или \"нет\".");
            }
        } while (true);
    }

    public void onAdv() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            if (stopAdverts()) {
                System.out.print("Для дальнейшего просмотра введите \"продолжить\": ");
                input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("продолжить")) {
                    break;
                } else {
                    System.out.println("Ошибка: Неверный ввод. Пожалуйста, введите \"продолжить\".");
                }
            } else {
                break;
            }
        }
    }
}