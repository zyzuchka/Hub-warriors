import java.util.Random;

public class Skeleton extends Creature{
    Random random = new Random();
    Skeleton() {
        super("Skeleton");
        setHp(150);
        setStrength(6);
        setAgility(4);
        setEvasion(5);
        setResistance(10);
        setExperience(50);
        setMoney(300);
        setLevel(1);
        setPotions(1);
    }
    @Override
    int attack(Creature creature) {
        int damage = getStrength() * getAgility() + (getExperience() / 10);
        System.out.println(getName() + " наносит " + damage + " урона.");
        return damage;
    }

    @Override
    int damageTaken(int base_damage) {
        if (getEvasion() > random.nextInt(100)) {
            System.out.println(getName() + " уклоняется!");
            return 0;
        } else {
            int damage = base_damage / getResistance();
            System.out.println(getName() + " получает " + damage + " урона.");
            setHp(getHp() - damage); // уменьшаем здоровье
            return damage;
        }
    }

    void die(Player player) {
        player.collect(getMoney(),getExperience());
        System.out.println("Монстр повержен. Игрок получил " + getMoney() + " золота и " + getExperience() + " опыта.");
    }
}
