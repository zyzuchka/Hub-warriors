import java.util.Random;

public class Forest implements Location, MonsterLocation {
    private Creature monster;
    private Random random = new Random();

    public Forest() {
        spawnRandomMonster();
    }

    private void spawnRandomMonster() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                monster = new Behemoth();
                break;
            case 1:
                monster = new Goblin();
                break;
            case 2:
                monster = new Skeleton();
                break;
        }
    }

    @Override
    public void describe() {
        System.out.println("Вы находитесь в лесу. Здесь могут быть монстры.");
    }

    @Override
    public Creature getMonster() {
        return monster;
    }

    @Override
    public void fightMonster(Player player) {
        System.out.println("Вы сражаетесь с монстром в лесу.");
    }

    @Override
    public boolean isMonsterAlive() {
        return monster.getHp() > 0;
    }
}
