import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Advert advertManager = new Advert();
        int choice = advertManager.chooseAdvert();
        advertManager.showAdverts();
    }
    }