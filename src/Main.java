import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu(); // Создаем экземпляр MainMenu
        Scanner scanner = new Scanner(System.in); // Создаем сканер для ввода

        System.out.print("Введите имя файла для поиска опции: ");
        String filename = scanner.nextLine(); // Считываем имя файла

        menu.searchOption(filename); // Пример поиска опции
        AdvertisingMenu advertisingMenu = new AdvertisingMenu();
        int adOption = advertisingMenu.chooseOptions();
        System.out.println("Вы выбрали рекламу: " + advertisingMenu.availableOptions[adOption - 1]);

        // Создаем экземпляр класса Advert с размером 5
        Advert originalAdvert = new Advert(5); // например, создаем 5 рекламных идентификаторов

        // Показываем рекламу
        originalAdvert.showAdverts();

        try {
            // Клонируем оригинальный объект
            Advert clonedAdvert = (Advert) originalAdvert.clone();

            // Теперь вы можете использовать клонированный объект
            System.out.println("Реклама снесена в маленькое окно");
            clonedAdvert.showAdverts(); // Показываем рекламу из клонированного объекта
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(); // Обрабатываем исключение, если клонирование не удалось
        }

        // Создаем объект Video и вызываем chooseVid
        Video video = new Video();
        video.chooseVid(); // Передаем Scanner в chooseVid
    }
}