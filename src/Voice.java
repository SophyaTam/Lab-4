import java.util.Scanner;

public class Voice {

    public void setVidVoice() {
        int loudness;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите уровень громкости (от 0 до 100): ");
            if (scanner.hasNextInt()) {
                loudness = scanner.nextInt();
                if (loudness >= 0 && loudness <= 100) {
                    System.out.println("Уровень громкости изменен до " + loudness);
                    break;
                } else {
                    System.out.println("Ошибка: Уровень громкости должен быть от 0 до 100.");
                }
            } else {
                System.out.println("Ошибка: Введите числовое значение.");
                scanner.next(); // Считываем неверный ввод
            }
        } while (true);
    }
}