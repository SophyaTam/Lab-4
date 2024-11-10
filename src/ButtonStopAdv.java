import java.util.Scanner;

public class ButtonStopAdv extends Advert {
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