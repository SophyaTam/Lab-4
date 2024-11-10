import java.util.Scanner;

public class VoiceInputHelper {
    public int getLoudness() {
        int loudness;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите уровень громкости (от 0 до 100): ");
            if (scanner.hasNextInt()) {
                loudness = scanner.nextInt();
                if (loudness >= 0 && loudness <= 100) {
                    return loudness;
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

