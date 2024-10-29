import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя вашего героя: ");
        String heroName = scanner.nextLine();

        Player player = new Player(heroName);
        LocationManager locationManager = new LocationManager(player);
        locationManager.start();
    }
}
