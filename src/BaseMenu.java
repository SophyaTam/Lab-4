import java.util.Scanner;

abstract class BaseMenu {
    protected MenuOption[] availableOptions;

    protected BaseMenu(int size) {
        availableOptions = new MenuOption[size];
        addOptions();
    }

    protected abstract void addOptions();

    public int chooseOptions() {
        Scanner scanner = new Scanner(System.in);
        int genre = 0;

        System.out.println("Доступные направления:");
        for (int i = 0; i < availableOptions.length; i++) {
            System.out.println(availableOptions[i]);
        }

        System.out.print("Выберите желаемое направление (1-" + availableOptions.length + "): ");
        while (true) {
            if (scanner.hasNextInt()) {
                genre = scanner.nextInt();
                if (genre >= 1 && genre <= availableOptions.length) {
                    break;
                } else {
                    System.out.println("Неверный ввод! Пожалуйста, введите число от 1 до " + availableOptions.length + ".");
                    scanner.next();
                }
            } else {
                System.out.println("Неверный ввод! Пожалуйста, введите число.");
                scanner.next();
            }
        }
        return genre;
    }

    // Внутренний класс для представления пункта меню
    protected static class MenuOption {
        String description;

        MenuOption(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}

