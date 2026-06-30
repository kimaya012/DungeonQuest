import entities.Player;
import entities.Monster;

public class Main{
    public static void main(String[] args){
        Player hero = new Player("Knight", 50, 12, 3);
        Monster goblin = new Monster("Goblin", 35, 8, 2);

        System.out.println(hero);
        System.out.println(goblin);
    }
    
}