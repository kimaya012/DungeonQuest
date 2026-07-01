import java.util.Scanner;
import entities.Player;
import entities.Monster;
import entities.Character;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Player hero = new Player("Knight", 50, 12, 3);
        Monster goblin = new Monster("Goblin", 35, 8, 2);

        // System.out.println(hero);
        // System.out.println(goblin);
        
        System.out.println("========== DUNGEON QUEST ==========");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            System.out.println("\n >");
            String command = sc.nextLine().trim().toLowerCase();

            switch (command) {
                case "help" :
                    System.out.println("\nAvailable commands: ");
                    System.out.println("attack");
                    System.out.println("status");
                    System.out.println("help");
                    System.out.println("quit");
                    break;

                case "status" :
                    displayHealth(hero, goblin);
                    break;
                
                case "attack" :
                    displayHealth(hero, goblin);

                    if(!hero.isAlive()) {
                        System.out.println(hero.getName() + "has been defeated!");
                    }

                    if (!goblin.isAlive()) {
                        System.out.println(goblin.getName() + "has been defeated!");
                    }

                    if (hero.isAlive() && goblin.isAlive()) {
                        hero.attack(goblin);

                        if (goblin.isAlive()) {
                            goblin.attack(hero);
                        }
                    } else {
                        System.out.println("The battle is already over.");
                    }
                    break;

                case "quit" :
                    System.out.println("Game over.");
                    sc.close();
                    return;
                
                default:
                    System.out.println("Invalid Command.");

            }
        }
    }
    //     while (hero.isAlive() && goblin.isAlive()) {
    //         hero.attack(goblin);
    //         displayHealth(hero, goblin);

    //         if (!goblin.isAlive()) {

    //             break;

    //         }

    //         goblin.attack(hero);
    //         displayHealth(hero, goblin);

    //     }

    //     System.out.println();

    //     if (hero.isAlive()) {

    //         System.out.println(hero.getName() + " wins!");

    //     } else {

    //         System.out.println(goblin.getName() + " wins!");

    //     }

    // }

    private static void displayHealth(Character first, Character second){
        System.out.println();
        System.out.println(first.getName() + " HP: " + first.getHp());
        System.out.println(second.getName() + " HP: " + second.getHp());
        System.out.println("-------------------------");
    }

}