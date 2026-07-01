package entities;

public class Monster extends GameCharacter {
    public Monster(String name, int hp, int attack, int defense) {
        super(name,hp,attack,defense);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " claws at " + target.getName() + "!" );
        target.takeDamage(attack);
    }
}