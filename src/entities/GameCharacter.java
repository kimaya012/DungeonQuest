package entities;

public abstract class GameCharacter{
    protected String name;
    protected int hp;
    protected int attack;
    protected int defense;

    public GameCharacter(String name, int hp, int attack,int defense){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }
    public abstract void attack(GameCharacter target);

    public boolean isAlive(){
        return hp > 0;
    }

    public void takeDamage(int damage){
        int finalDamage = damage - defense;

        if(finalDamage < 0){
            finalDamage = 0;
        }

        hp -= finalDamage;

        if(hp < 0){
            hp = 0;
        }

        System.out.println(name + " takes " + finalDamage + " damage ");
    }

    public int getHp(){
        return hp;
    }

    public String getName(){
        return name;
    }

    @Override
    public  String toString() {
        return name + " | HP: " + hp + " | ATTACK: " + attack + " | DEFENSE: " + defense;

        }
}
