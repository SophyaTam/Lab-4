import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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
        try (Scanner fileScanner = new Scanner(new File(genre + ".txt"))) {
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
    public void chooseVid(MainMenu menu) {
        int totalVideos = availableVideos.size();
        openVid(menu.chooseOptions());
        while (true) {
            if (totalVideos == 0) {
                System.out.println("Нет доступных видео для воспроизведения!");
                break;
            }
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
            Voice voi = new Voice();
            voi.setVidVoice();
            ButtonStopVid vid = new ButtonStopVid();
            vid.onVid();
            EndWork end = new EndWork();
            end.end();
            totalVideos--;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Если вы хотите выйти из плеера, нажмите 1, иначе - 0: ");
            int choice = scanner.nextInt();
            scanner.close();
            if (choice == 1) {
                break;
            }
        }
    }
}
