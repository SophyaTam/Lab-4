import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class Video {
    private static final int N = 10; // Define N here. Adjust as needed.
    private static final int M = 100; // Define M here. Adjust as needed.
    private List<String> shownVideos;
    private List<String> availableVideos;

    public Video() {
        shownVideos = new ArrayList<>(N);
        availableVideos = new ArrayList<>(N);
        initializeShownVideos();
    }

    // Method to populate the array with video names for viewing
    public void openVid(int genre) {
        String filePath = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\" + genre + ".txt";
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine() && availableVideos.size() < N) {
                availableVideos.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
    }

    // Method to populate the array with played videos
    private void initializeShownVideos() {
        for (int i = 0; i < N; i++) {
            shownVideos.add("");
        }
    }

    // Method to output a random video
    public void chooseVid(MainMenu menu, ButtonStopVid stopV) {
        try (Scanner scanner = new Scanner(System.in)) {
            int genre = menu.chooseOptions();
            openVid(genre);
            int totalVideos = availableVideos.size();

            if (totalVideos == 0) {
                System.out.println("Нет доступных видео для воспроизведения!");
                return;
            }

            while (totalVideos > 0) {
                Random random = new Random();
                int randomIndex;
                boolean allow;
                do {
                    randomIndex = random.nextInt(totalVideos);
                    allow = true;
                    for (String shownVideo : shownVideos) {
                        if (shownVideo.equals(availableVideos.get(randomIndex))) {
                            allow = false;
                            break;
                        }
                    }
                } while (!allow);
                for (int i = 0; i < shownVideos.size(); i++) {
                    if (shownVideos.get(i).isEmpty()) {
                        shownVideos.set(i, availableVideos.get(randomIndex));
                        break;
                    }
                }
                System.out.println("Воспроизводится видео: " + availableVideos.get(randomIndex));
                try {
                    stopV.onVid(scanner);
                } catch (InputMismatchException e) {
                    System.out.println("Неверный ввод! Пожалуйста, введите число.");
                    scanner.next(); // Consume bad input
                } catch (NoSuchElementException e) {
                    System.err.println("Ошибка ввода! Поток ввода закрыт.");
                    return; // Indicate failure
                }

                totalVideos--;

                int choice = -1;
                while (choice != 1 && choice != 0) {
                    try {
                        System.out.print("Выйти из плеера? (1 - да, 0 - нет): ");
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    } catch (InputMismatchException e) {
                        System.out.println("Неверный ввод! Пожалуйста, введите 1 или 0.");
                        scanner.next(); // Consume bad input
                    } catch (NoSuchElementException e) {
                        System.err.println("Ошибка ввода! Поток ввода закрыт.");
                        return; // Indicate failure
                    }
                }
                if (choice == 1) {
                    break;
                }
            }
        }
    }
}