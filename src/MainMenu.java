import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Базовый класс для опций меню
abstract class MenuOption {
    public abstract String getName();
}

// Производные классы для различных типов опций
class MelodramaOption extends MenuOption {
    @Override
    public String getName() {
        return "Мелодраммы";
    }
}

class ChildOption extends MenuOption {
    @Override
    public String getName() {
        return "Детское";
    }
}

class DetectiveOption extends MenuOption {
    @Override
    public String getName() {
        return "Детективы";
    }
}

class ComedyOption extends MenuOption {
    @Override
    public String getName() {
        return "Комедии";
    }
}

class SeriesOption extends MenuOption {
    @Override
    public String getName() {
        return "Сериалы";
    }
}

// Контейнер для хранения опций меню
class MenuOptionsContainer {
    private List<MenuOption> options = new ArrayList<>();

    public void addOption(MenuOption option) {
        options.add(option);
    }

    public List<MenuOption> getOptions() {
        return options;
    }

    public int size() {
        return options.size();
    }

    // Метод для сортировки опций по имени
    public void sortOptions() {
        Collections.sort(options, Comparator.comparing(MenuOption::getName));
    }

    // Метод для поиска опции по имени
    public MenuOption findOption(String name) {
        for (MenuOption option : options) {
            if (option.getName().equals(name)) {
                return option;
            }
        }
        return null; // Возвращаем null, если опция не найдена
    }
}

abstract class Menu {
    public abstract void addOptions(); // Чисто виртуальная функция для добавления опций
    public abstract int chooseOptions(); // Чисто виртуальная функция для выбора опции
}

// Класс главного меню
class MainMenu extends Menu {
    private MenuOptionsContainer availableOptions = new MenuOptionsContainer(); // Используем контейнер для опций

    public MainMenu() {
        addOptions();
        availableOptions.sortOptions(); // Сортируем опции при инициализации
    }

    @Override
    public void addOptions() {
        availableOptions.addOption(new ChildOption());
        availableOptions.addOption(new DetectiveOption());
        availableOptions.addOption(new ComedyOption());
        availableOptions.addOption(new MelodramaOption());
        availableOptions.addOption(new SeriesOption());
    }

    @Override
    public int chooseOptions() {
        int choice = 0;
        List<MenuOption> options = availableOptions.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getName());
        }
        System.out.print("Выберите желаемое направление (1-" + options.size() + "): ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= options.size()) {
                    break;
                }
            } else {
                scanner.next(); // Сбрасываем неверный ввод
            }
            System.out.println("Неверный ввод! Пожалуйста, введите число от 1 до " + options.size() + ".");
        }
        return choice;
    }

    public void searchOption(String name) {
        MenuOption option = availableOptions.findOption(name);
        if (option != null) {
            System.out.println("Опция '" + name + "' найдена! Она содержит: ");
            String filename = null;

            switch (name) {
                case "Детское":
                    filename = "1.txt";
                    break;
                case "Детективы":
                    filename = "2.txt";
                    break;
                case "Комедии":
                    filename = "3.txt";
                    break;
                case "Мелодрамы":
                    filename = "4.txt";
                    break;
                case "Сериалы":
                    filename = "5.txt";
                    break;
            }

            // Проверяем, был ли выбран файл
            if (filename != null) {
                try (Scanner fileScanner = new Scanner(new java.io.File(filename))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line); // Выводим содержимое строки
                    }
                } catch (java.io.FileNotFoundException e) {
                    System.err.println("Ошибка открытия файла: " + e.getMessage());
                }
            } else {
                System.out.println("Опция '" + name + "' не найдена.");
            }
        }
    }
}