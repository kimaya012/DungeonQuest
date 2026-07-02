package items;
import entities.Player;

public class Potion extends Item {
    private int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public String toString() {
        return name + " (Heals " + healAmount + "HP)";
    }

    @Override
    public void use(Player player) {
        System.out.println("You used "+ name + ".");
        player.heal(healAmount);
    }
}