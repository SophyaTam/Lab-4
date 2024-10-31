import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Advert advert = new Advert();
        advert.showAdverts();
        Video video = new Video();
        video.chooseVid(); // Передаем Scanner в chooseVid
    }}