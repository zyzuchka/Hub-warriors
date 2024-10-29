import java.util.Random;

public class Goblin extends Creature{
    Random random = new Random();
    Goblin() {
        super("Goblin");
        setHp(50);
        setStrength(1);
        setAgility(6);
        setEvasion(40);
        setResistance(0);
        setExperience(10);
        setMoney(100);
        setLevel(1);
        setPotions(0);
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
}
