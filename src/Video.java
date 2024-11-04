import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Video {
    private List<String> lastVid;
    private List<String> allVid;
    private final int N = 10;
    private final int M = 100;

    public Video() {
        lastVid = new ArrayList<>(N);
        allVid = new ArrayList<>(N);
        LastVids();
    }
    public void openVid() {
        MainMenu menu = new MainMenu();
        int djanre = menu.chooseOptions();
        String filePath = djanre + ".txt";
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine() && allVid.size() < N) {
                allVid.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка открытия файла: " + e.getMessage());
        }
    }

    public void LastVids() {
        for (int i = 0; i < N; i++) {
            lastVid.add("");
        }
    }
    public void chooseVid() {
        openVid();
        int totalVideos = allVid.size();
        int vidPlayerOn = 0;

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
            vidPlayerOn = scanner.nextInt();

            if (vidPlayerOn == 1) {
                break;
            }
        }
        if (vidPlayerOn == 1) {
            chooseVid();
        }
    }
}