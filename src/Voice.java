import java.util.Scanner;

public class Voice {
    private Scanner scanner; // Добавляем поле scanner

    public Voice(Scanner scanner) { // Конструктор для получения Scanner
        this.scanner = scanner;
    }

    public void setVidVoice() {
        int loudness;
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