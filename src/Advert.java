import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Advert {
    private static final int N = 10; // Define N here. Adjust as needed.
    private List<Integer> advertIds;
    private List<Integer> shownAdverts;

    public Advert() {
        advertIds = new ArrayList<>(N);
        shownAdverts = new ArrayList<>(N);
        initializeAdverts();
    }

    // Method to get user input for enabling/disabling adverts
    public int chooseAdvert() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.print("Введите 1, если хотите добавить рекламу, и 0 - если нет: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.close();
        return choice;
    }

    // Method to initialize advert IDs
    private void initializeAdverts() {
        for (int i = 1; i <= N; i++) {
            advertIds.add(i);
        }
    }

    // Method to show adverts
    public void showAdverts() {
        int turnOn = chooseAdvert();
        if (turnOn == 1) {
            Random random = new Random();
            int randomIndex;
            boolean allow;
            do {
                randomIndex = random.nextInt(advertIds.size());
                allow = true;
                for (int shownAdvert : shownAdverts) {
                    if (advertIds.get(randomIndex) == shownAdvert) {
                        allow = false;
                        break;
                    }
                }
            } while (!allow);
            System.out.println("Играет реклама: #" + advertIds.get(randomIndex));
            ButtonStopAdv adv = new ButtonStopAdv();
            adv.onAdv();
            shownAdverts.add(advertIds.get(randomIndex));
        }
    }
}

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
