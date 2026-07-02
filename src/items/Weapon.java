package items;
import entities.Player;

public class Weapon extends Item {

    private int attackBonus;

    public Weapon (String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public String toString() {
        return name + "(+ " + attackBonus + " Attack)";
    }

    @Override
    public void use(Player player) {
        System.out.println("You equipped "+ name + ".");
    }
}