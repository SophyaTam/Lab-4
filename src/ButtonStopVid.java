import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ButtonStopVid extends Video { // ButtonStopVid extends Video
    // Method to stop the video via input 1
    public boolean stopVids() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.print("Если хотите остановить видео, нажмите 1, иначе - 0: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.close();
        if (choice == 1) {
            System.out.println("Видео остановлено");
        }
        return choice == 1;
    }

    // Method to resume viewing via input 1
    public void onVid() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            if (stopVids()) {
                System.out.print("Для дальнейшего просмотра нажмите 1: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Неверный ввод! Пожалуйста, введите 1.");
                    scanner.next();
                }
                choice = scanner.nextInt();
                if (choice == 1) {
                    break;
                }
            } else {
                break;
            }
        }
        scanner.close();
    }
}