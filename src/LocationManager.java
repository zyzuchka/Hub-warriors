import java.util.Scanner;

public class LocationManager {
    private Location currentLocation;
    private Player player;

    public LocationManager(Player player) {
        this.player = player;
        this.currentLocation = new Hub(); // начальная локация - хаб
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            currentLocation.describe();
            System.out.println("Выберите действие: ");
            System.out.println("1. Пойти в другую локацию");
            System.out.println("2. Атаковать монстра");
            if (currentLocation instanceof Trader) {
                System.out.println("3. Купить лечебное зелье");
            }
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    chooseLocation(scanner);
                    player.displayStatus(); // Показываем статус после выбора локации
                    break;
                case 2:
                    if (currentLocation instanceof MonsterLocation) {
                        MonsterLocation monsterLocation = (MonsterLocation) currentLocation;
                        Creature monster = monsterLocation.getMonster();
                        Battle battle = new Battle(player, monster);
                        Thread battleThread = new Thread(battle);
                        battleThread.start();
                        try {
                            battleThread.join(); // Ждём завершения боя
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("Процесс битвы был прерван.");
                        }
                        if (!monsterLocation.isMonsterAlive()) {
                            System.out.println("Монстр побежден! Возвращаемся в хаб.");
                            currentLocation = new Hub();
                        }
                    } else {
                        System.out.println("Здесь нет монстров для атаки.");
                    }
                    player.displayStatus(); // Показываем статус после атаки
                    break;
                case 3:
                    if (currentLocation instanceof Trader) {
                        ((Trader) currentLocation).buyPotion(player);
                    } else {
                        System.out.println("Недопустимое действие в этой локации.");
                    }
                    player.displayStatus(); // Показываем статус после покупки
                    break;
                case 0:
                    System.out.println("Выход из игры.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private void chooseLocation(Scanner scanner) {
        System.out.println("Выберите локацию:");
        System.out.println("1. Лес");
        System.out.println("2. Торговец");
        System.out.println("0. Назад в хаб");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentLocation = new Forest();
                break;
            case 2:
                currentLocation = new Trader();
                break;
            case 0:
                currentLocation = new Hub();
                break;
            default:
                System.out.println("Некорректный выбор. Остаемся на месте.");
        }
    }
}
