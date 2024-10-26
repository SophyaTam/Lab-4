import java.util.Scanner;

public class ButtonStopAdv extends Advert { // ButtonStopAdv now extends Advert
    // Method to stop the advertisement (returns true if stopped, false otherwise)
    public boolean stopAdverts() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Если хотите остановить видео, нажмите 1, иначе - 0: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 0 && choice <= 1) {
                    scanner.close();
                    return (choice == 1);
                } else {
                    System.out.println("Ошибка: Если хотите остановить видео, нажмите 1, иначе - 0.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Ошибка: введите числовое значение.");
                scanner.next();
            }
        } while (true);
    }

    // Method to resume playing the video
    public void onAdv() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            if (stopAdverts()) {
                System.out.print("Для дальнейшего просмотра нажмите 1: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice == 1) {
                        break;
                    } else {
                        System.out.println("Неверный ввод! Пожалуйста, введите 1.");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите число.");
                    scanner.next();
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}