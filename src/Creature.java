public abstract class Creature {
    //parameters
    private String name;
    private int hp;
    private int strength;
    private int agility;
    private int evasion;
    private int resistance;
    private int experience;
    private int money;
    private int level;
    private String[] inventory;
    private int potions;

    //constructors
    Creature(String name){
        this.name = name;
    }

    //getters for everything
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getStrength() {
        return strength;
    }
    public int getAgility() {
        return agility;
    }
    public int getEvasion() {
        return evasion;
    }
    public int getResistance() {
        return resistance;
    }
    public int getExperience() {
        return experience;
    }
    public int getMoney() {
        return money;
    }
    public int getLevel() {
        return level;
    }
    public String[] getInventory() {
        return inventory;
    }
    public int getPotions() {
        return potions;
    }

    //setters for everything
    // make sure to pass negative values as damage for subtraction to work correctly
    public void setName(String name) { this.name = name; }
    public void setHp(int hp) { this.hp = hp; }
    public void adjustHp(int hp) { this.hp += hp; }
    public void setStrength(int strength) { this.strength = strength; }
    public void adjustStrength(int strength) { this.strength += strength; }
    public void setAgility(int agility) { this.agility = agility; }
    public void adjustAgility(int agility) { this.agility += agility; }
    public void setEvasion(int evasion) { this.evasion = evasion; }
    public void adjustEvasion(int evasion) { this.evasion += evasion; }
    public void setResistance(int resistance) { this.resistance = resistance; }
    public void adjustResistance(int resistance) { this.resistance += resistance; }
    public void setExperience(int experience) { this.experience = experience; }
    public void adjustExperience(int experience) { this.experience += experience; }
    public void setMoney(int money) { this.money = money; }
    public void adjustMoney(int money) { this.money += money; }
    public void setLevel(int level) { this.level = level; }
    public void addLevel(int level) { this.level += level; }
    public void setPotions(int potions) { this.potions = potions; }
    public void adjustPotions(int potions) { this.potions += potions; }
    //setters for inventory
    /*public void addInventory(String[] inventory) {
        this.inventory
    }*/

    //methods
    abstract int attack(Creature creature);
    abstract int damageTaken(int base_damage);
}
