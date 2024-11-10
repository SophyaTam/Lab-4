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
    public int chooseAdvert() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.print("Введите 1, если хотите добавить рекламу, и 0 - если нет: ");
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice == 0 || choice == 1) {
                    break; // Выходим из цикла, если ввод корректен
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите целое число (1 или 0).");
                scanner.next(); // Очищаем буфер сканера от некорректного ввода
            }
        }

        return choice;
    }
    private void initializeAdverts() {
        for (int i = 1; i <= N; i++) {
            advertIds.add(i);
        }
    }
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

