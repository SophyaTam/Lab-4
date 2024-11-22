import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AdvertisingMenu advertisingMenu = new AdvertisingMenu();
        int adOption = advertisingMenu.chooseOptions();
        System.out.println("Вы выбрали рекламу: " + advertisingMenu.availableOptions[adOption - 1]);
        // Создаем экземпляр класса Advert с размером 10
        Advert advert = new Advert(10);
        // Показываем рекламу
        advert.showAdverts();
        Video video = new Video();
        video.chooseVid(); // Передаем Scanner в chooseVid
    }}