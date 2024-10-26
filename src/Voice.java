import java.util.Scanner;

public class Voice {
    private int loudness; // Changed to a more descriptive name

    public void setVidVoice() { // Changed method name for clarity
        Scanner scanner = new Scanner(System.in);
        int loudness;

        do {
            System.out.print("Введите уровень громкости (от 0 до 100): ");
            if (scanner.hasNextInt()) {
                loudness = scanner.nextInt();
                if (loudness >= 0 && loudness <= 100) {
                    this.loudness = loudness; // Store the valid loudness
                    System.out.println("Уровень громкости видео изменен до " + loudness);
                    break; // Exit the loop if input is valid
                } else {
                    System.out.println("Ошибка: уровень громкости должен быть в пределах от 0 до 100.");
                    scanner.nextLine(); // Consume the rest of the line
                }
            } else {
                System.out.println("Ошибка: введите числовое значение.");
                scanner.next(); // Consume the non-integer input
            }
        } while (true); // Loop until valid input is received

        scanner.close();
    }
}