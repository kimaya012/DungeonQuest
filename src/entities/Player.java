package entities;

public class Player extends GameCharacter {
    public Player(String name, int hp, int attack, int defense) {
        super(name,hp,attack,defense);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attack);
    }
}