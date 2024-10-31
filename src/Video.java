import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

class Video {
    private List<String> lastVid;
    private List<String> allVid;
    private final int N = 10; // Adjust the size according to requirements
    private final int M = 100; // Adjust the size according to requirements

    public Video() {
        lastVid = new ArrayList<>(N);
        allVid = new ArrayList<>(N);
        LastVids();
    }

    // Method to fill the array with video names for viewing
    public void openVid() {
        MainMenu menu = new MainMenu();
        int djanre = menu.chooseOptions();
        String filePath = "C:\\Users\\User\\IdeaProjects\\untitled\\src\\" + djanre + ".txt";
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine() && allVid.size() < N) {
                allVid.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
    }

    // Method to fill the array with played videos
    public void LastVids() {
        for (int i = 0; i < N; i++) {
            lastVid.add(""); // Initializing to empty strings
        }
    }
    public void chooseVid() {
        openVid();
        int totalVideos = allVid.size();
        int vidPlayerOn = 0; // Change here to 'int'

        if (totalVideos == 0) {
            System.out.println("Нет доступных видео для воспроизведения!");
            return;
        }

        Random random = new Random();
        while (totalVideos > 0) {
            int randomIndex;
            boolean allow;

            do {
                randomIndex = random.nextInt(totalVideos);
                allow = true;
                for (String lastVideo : lastVid) {
                    if (lastVideo.equals(allVid.get(randomIndex))) {
                        allow = false;
                        break;
                    }
                }
            } while (!allow);

            for (int i = 0; i < N; i++) {
                if (lastVid.get(i).isEmpty()) {
                    lastVid.set(i, allVid.get(randomIndex));
                    break;
                }
            }
            Voice voice=new Voice();
            voice.setVidVoice();
            System.out.println("Воспроизводится видео: " + allVid.get(randomIndex) + "........");
            ButtonStopVid vid = new ButtonStopVid();
            vid.onVid();
            EndWork endWork = new EndWork();
            endWork.end();
            totalVideos--;

            System.out.println("Если вы хотите выйти из плеера, нажмите 1, иначе - 0");
            Scanner scanner = new Scanner(System.in);
            vidPlayerOn = scanner.nextInt(); // Use the existing int variable

            if (vidPlayerOn == 1) {
                break; // Exit loop if user wants to stop
            }
        }
        if (vidPlayerOn == 1) {
            chooseVid(); // Recursively call to chooseVid if user wants to continue
        }
    }
}