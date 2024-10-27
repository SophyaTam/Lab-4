import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

class ButtonStopVid {
    public boolean stopVids(Scanner scanner) {
        int choice = -1;
        while (choice != 1 && choice != 0) {
            try {
                System.out.print("Остановить видео? (1 - да, 0 - нет): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
                scanner.next(); // Consume bad input
            } catch (NoSuchElementException e) {
                System.err.println("Ошибка ввода! Поток ввода закрыт.");
                return false; // Indicate failure
            }
        }
        if (choice == 1) {
            System.out.println("Видео остановлено");
        }
        return choice == 1;
    }

    public void onVid(Scanner scanner) {
        if (stopVids(scanner)) {
            int choice = 0;
            while (choice != 1) {
                try {
                    System.out.print("Продолжить просмотр? (1 - да): ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод! Пожалуйста, введите 1.");
                    scanner.next(); // Consume bad input
                } catch (NoSuchElementException e) {
                    System.err.println("Ошибка ввода! Поток ввода закрыт.");
                    return; // Indicate failure
                }
            }
        }
    }
}