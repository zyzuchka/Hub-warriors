import java.util.Random;

public class Behemoth extends Creature{
    Random random = new Random();
    Behemoth() {
        super("Behemoth");
        setHp(500);
        setStrength(9);
        setAgility(1);
        setEvasion(0);
        setResistance(50);
        setExperience(100);
        setMoney(1000);
        setLevel(1);
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
