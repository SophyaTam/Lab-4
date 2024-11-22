import java.util.Scanner;

class ButtonStopVid extends Video {
    private char stopVid;
    private char vidPlayerOn;

    // Метод остановки видео
    public char stopVids() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Если хотите остановить видео, нажмите 1, иначе - 0");
        if (scanner.hasNext()) {
            stopVid = scanner.next().charAt(0);
            if (stopVid == '1') {
                System.out.println("Видео остановлено");
            }
        } else {
            System.out.println("No input available.");
            stopVid = '0';
        }
        return stopVid;
    }
    // Перегрузка метода chooseVid() из базового класса
    @Override
    public void chooseVid() {
        // Вызов метода базового класса
        super.chooseVid(); // Вызываем метод chooseVid() из Video
        System.out.println("Видео выбранно"); // Ваша дополнительная логика
    }
    // Метод для продолжения просмотра
    public void onVid() {
        Scanner scanner = new Scanner(System.in);
        stopVid = '0';
        vidPlayerOn = '0';
        while (true) {
            stopVid = stopVids();
            if (stopVid == '0') {
                System.out.println("Вы выбрали продолжить.");
                break;
            }
            System.out.println("Для дальнейшего просмотра нажмите 1");
            if (scanner.hasNext()) {
                vidPlayerOn = scanner.next().charAt(0);
                if (vidPlayerOn == '1') {
                    break;
                }
            } else {
                System.out.println("No input available.");
                break; // Выйдем из цикла, если нет ввода
            }
        }
    }
}