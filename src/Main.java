import entities.Player;
import entities.Monster;

public class Main{
    public static void main(String[] args){
        Player hero = new Player("Knight", 50, 12, 3);
        Monster goblin = new Monster("Goblin", 35, 8, 2);

        System.out.println(hero);
        System.out.println(goblin);
        
        System.out.println("\n========== BATTLE START ==========\n");

        while (hero.isAlive() && goblin.isAlive()) {
            hero.attack(goblin);
            displayHealth(hero, goblin);

            if (!goblin.isAlive()) {

                break;

            }

            goblin.attack(hero);
            displayHealth(hero, goblin);

        }

        System.out.println();

        if (hero.isAlive()) {

            System.out.println(hero.getName() + " wins!");

        } else {

            System.out.println(goblin.getName() + " wins!");

        }

    }

    private static void displayHealth(Player hero, Player goblin){
        System.out.println();
        System.out.println(hero.getName() + " HP: " + hero.getHp());
        System.out.println(goblin.getName() + " HP: " + goblin.getHp());
        System.out.println("-------------------------");
    }

}