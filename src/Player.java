import java.util.Random;

public class Player extends Creature {
    Random random = new Random();

    Player(String name) {
        super(name);
        setHp(100);
        setStrength(5);
        setAgility(5);
        setEvasion(20);
        setResistance(15);
        setExperience(0);
        setMoney(100);
        setLevel(1);
        setPotions(5);
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
            adjustHp(-damage); // уменьшаем здоровье
            usePotionIfNecessary(); // Используем зелье, если нужно
            return damage;
        }
    }

    private void usePotionIfNecessary() {
        if (getHp() < 30 && getPotions() > 0) {
            adjustHp(50); // увеличиваем здоровье на 50
            adjustPotions(-1); // уменьшаем количество зелий на 1
            System.out.println(getName() + " использует зелье. Восстановлено 50 HP. Теперь у вас " + getHp() + " HP и " + getPotions() + " зельев.");
        }
    }

    void collect(int money, int experience) {
        adjustMoney(money); // добавляем деньги
        addExperience(experience); // добавляем опыт и проверяем уровень
        System.out.println("Игрок собрал " + money + " золота. Теперь у него " + getMoney() + " золота.");
        System.out.println("Игрок собрал " + experience + " опыта. Теперь у него " + getExperience() + " опыта.");
        displayStatus();
    }

    void buyPotion() {
        if (getMoney() >= 50) {
            adjustMoney(-50); // уменьшаем деньги на 50
            adjustPotions(1); // увеличиваем количество зелий на 1
            System.out.println("Вы купили лечебное зелье. Теперь у вас " + getPotions() + " зельев и " + getMoney() + " монет.");
        } else {
            System.out.println("Недостаточно монет для покупки лечебного зелья.");
        }
    }

    void displayStatus() {
        System.out.println("Статус героя:");
        System.out.println("Имя: " + getName());
        System.out.println("Здоровье: " + getHp());
        System.out.println("Зелья: " + getPotions());
        System.out.println("Опыт: " + getExperience());
        System.out.println("Уровень: " + getLevel());
        System.out.println("Деньги: " + getMoney());
    }

    private void addExperience(int experience) {
        adjustExperience(experience); // добавляем опыт
        while (getExperience() >= 100) {
            adjustExperience(-100); // вычитаем 100 опыта
            addLevel(1); // увеличиваем уровень на 1
            System.out.println(getName() + " получает новый уровень! Теперь у него уровень " + getLevel() + ".");
        }
    }
}
