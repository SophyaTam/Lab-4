import java.util.Scanner;
public class MainMenu extends BaseMenu {
    public MainMenu() {
        super(5); // Фиксированный размер массива
    }

    @Override
    protected void addOptions() {
        availableOptions[0] = new MenuOption("1-Детское");
        availableOptions[1] = new MenuOption("2-Детективы");
        availableOptions[2] = new MenuOption("3-Комедии");
        availableOptions[3] = new MenuOption("4-Мелодрамы");
        availableOptions[4] = new MenuOption("5-Сериалы");
    }
}
