import java.util.Scanner;

public class AdvertisingMenu extends BaseMenu {
    public AdvertisingMenu() {
        super(4); // Фиксированный размер массива для рекламы
    }

    @Override
    protected void addOptions() {
        availableOptions[0] = new MenuOption("1-Реклама фильма");
        availableOptions[1] = new MenuOption("2-Реклама сериала");
        availableOptions[2] = new MenuOption("3-Реклама акции");
        availableOptions[3] = new MenuOption("4-Выход");
    }
}
