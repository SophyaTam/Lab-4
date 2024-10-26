import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Advert {
    private boolean advertEnabled; // Using boolean for advert state
    private List<Integer> advertIds; // Using ArrayList for dynamic sizing
    private List<Integer> shownAdverts; // Using ArrayList to track shown adverts


    public Advert() {
        advertIds = new ArrayList<>();
        shownAdverts = new ArrayList<>();
        initializeAdverts(); // Initialize advert IDs
    }

    // Method to get user input for enabling/disabling adverts
    public int chooseAdvert() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.print("Введите 1, если хотите добавить рекламу, и 0 - если нет: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
            scanner.next(); // Consume invalid input
        }
        choice = scanner.nextInt();
        scanner.close();
        return choice;
    }

    // Method to initialize advert IDs (replace with your actual advert IDs)
    private void initializeAdverts() {
        for (int i = 1; i <= 10; i++) { //Example: 10 advert IDs.  Change as needed
            advertIds.add(i);
        }
    }
    // Method to add advert to shownAdverts list
    public void addShownAdvert(int advertId) {
        shownAdverts.add(advertId);
    }
    // Method to check if advert has already been shown
    public boolean isAdvertShown(int advertId) {
        return shownAdverts.contains(advertId);
    }
    // Method to show adverts (replace with your actual advert showing logic)
    public void showAdverts() {
        if (advertEnabled) {
            for (int advertId : advertIds) {
                if (!isAdvertShown(advertId)) {
                    System.out.println("Showing advert: " + advertId);
                    addShownAdvert(advertId);
                    break; // Show only one advert at a time.
                }
            }
        }
    }
    public static void main(String[] args) {
        Advert advertManager = new Advert();
        int choice = advertManager.chooseAdvert();
        advertManager.advertEnabled = (choice == 1); // Set advertEnabled based on user input
        advertManager.showAdverts();
    }
}