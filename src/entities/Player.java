package entities;

public class Player extends Character {
    public Player(String name, int hp, int attack, int defense) {
        super(name,hp,attack,defense);
    }

    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attack);
    }
}