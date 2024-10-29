public interface MonsterLocation {
    Creature getMonster();
    void fightMonster(Player player);
    boolean isMonsterAlive();
}
