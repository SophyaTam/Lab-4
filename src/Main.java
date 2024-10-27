import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        ButtonStopVid stopV = new ButtonStopVid();
        Video video = new Video();
        video.chooseVid(menu, stopV);
    }}