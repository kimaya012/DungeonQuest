import java.util.Scanner;
import entities.*;
import java.util.ArrayList;
import world.*;
import engine.CommandParser;
import items.Item;
import items.Potion;
import items.Weapon;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        Player hero = new Player("Knight", 50, 12, 3);
        Monster goblin = new Monster("Goblin", 35, 8, 2);

        Dungeon dungeon = new Dungeon();
        Room currentRoom = dungeon.getStartingRoom();

        // ArrayList<String> inventory = new ArrayList<>();
        ArrayList<Item> inventory = new ArrayList<>();

        // inventory.add("Health Potion");
        // inventory.add("Wooden Sword");

        inventory.add(new Potion("Health Potion",20));
        inventory.add(new Weapon("Wooden Sword", 5));

        // System.out.println(hero);
        // System.out.println(goblin);
        
        System.out.println("========== DUNGEON QUEST ==========");
        System.out.println("Type 'help' to see available commands.");

        while (true) {
            System.out.println("\n >");
            // String command = sc.nextLine().trim().toLowerCase();
            String[] parts = CommandParser.parse(sc.nextLine());
            if (parts.length == 0) {
                continue;
            }

            String command = parts[0].toLowerCase();

            switch (command) {
                case "help" :
                    System.out.println("\nAvailable commands: ");
                    System.out.println("attack");
                    System.out.println("status");
                    System.out.println("inventory");
                    System.out.println("use");
                    System.out.println("look");
                    System.out.println("move");
                    System.out.println("help");
                    System.out.println("quit");

                   
                    break;

                case "status" :
                    displayHealth(hero, goblin);
                    break;

                case "look":
                    currentRoom.displayRoom();
                    break;

                case "move" :
                    if (parts.length < 2) {
                        System.out.println("Move where?");
                        break;
                    }

                    Room nextRoom = currentRoom.getExit(parts[1]);

                    if(nextRoom != null) {
                        currentRoom = nextRoom;
                        currentRoom.displayRoom();
                    } else {
                        System.out.println("You can't move " + parts[1] + ".");
                    }
                    break;

                case "use" :
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                        break;
                    }
                    Item item = inventory.get(0);
                    item.use(hero);
                    break;
                
                case "attack" :
                    displayHealth(hero, goblin);

                    if(!hero.isAlive()) {
                        System.out.println(hero.getName() + " has been defeated!");
                    }

                    if (!goblin.isAlive()) {
                        System.out.println(goblin.getName() + " has been defeated!");
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

                case "inventory" :
                    if (inventory.isEmpty()) {
                        System.out.println("Inventory is empty.");
                    } else {
                        System.out.println("\nInventory: ");
                        for(int i = 0; i < inventory.size(); i++) {
                            System.out.println((i+1) + ". " + inventory.get(i));
                        }
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

    private static void displayHealth(GameCharacter first, GameCharacter second){
        System.out.println();
        System.out.println(first.getName() + " HP: " + first.getHp());
        System.out.println(second.getName() + " HP: " + second.getHp());
        System.out.println("-------------------------");
    }

}