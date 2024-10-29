public class Battle implements Runnable {
    private Player player;
    private Creature opponent;

    public Battle(Player player, Creature opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    @Override
    public void run() {
        while (player.getHp() > 0 && opponent.getHp() > 0) {
            int damageToOpponent = player.attack(opponent);
            opponent.setHp(opponent.getHp() - damageToOpponent);  // Правильное уменьшение здоровья противника

            if (opponent.getHp() <= 0) {
                System.out.println(opponent.getName() + " побежден!");
                player.collect(opponent.getMoney(), opponent.getExperience());
                break;
            }

            int damageToPlayer = opponent.attack(player);
            player.setHp(player.getHp() - player.damageTaken(damageToPlayer));  // Правильное уменьшение здоровья игрока

            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " побежден!");
                break;
            }

            displayStatus();

            // Симуляция времени на каждый раунд
            try {
                Thread.sleep(1000); // Ожидание 1 секунду между раундами
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Бой был прерван.");
            }
        }
    }

    private void displayStatus() {
        System.out.println("Статус после раунда:");
        player.displayStatus();
        System.out.println(opponent.getName() + ": Здоровье: " + opponent.getHp());
    }
}
