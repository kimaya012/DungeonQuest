package entities;

public class Player extends GameCharacter {
    public Player(String name, int hp, int attack, int defense) {
        super(name,hp,attack,defense);
    }
    public void heal(int amount) {
        hp += amount;
        System.out.println(name + " recovered "+ amount + " HP.");
    }
    

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attack);
    }
}