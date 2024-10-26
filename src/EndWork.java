import java.util.Scanner;

public class EndWork {
    public void end() {
        Scanner scanner = new Scanner(System.in);
        int endAll = 0;
        System.out.println("Если хотите завершить работу видеопроигрывателя, нажмите 7");
            endAll = scanner.nextInt();
            if (endAll == 7) {
                System.out.println("Завершение сеанса...");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Работа проигрывателя продолжается.");
            }
        scanner.close(); // Close the scanner
    }
}
