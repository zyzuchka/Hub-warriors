public class Trader implements Location {
    @Override
    public void describe() {
        System.out.println("Вы находитесь у торговца. Здесь можно купить лечебные зелья за 50 монет.");
    }

    public void buyPotion(Player player) {
        if (player.getMoney() >= 50) {
            player.setMoney(- 50);
            player.setPotions(1);
            System.out.println("Вы купили лечебное зелье. Теперь у вас " + player.getPotions() + " зельев и " + player.getMoney() + " монет.");
        } else {
            System.out.println("Недостаточно монет для покупки лечебного зелья.");
        }
    }
}
