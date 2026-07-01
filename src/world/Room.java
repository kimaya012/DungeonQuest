package world;

import java.util.HashMap;

public class Room {
    private String name;
    private HashMap<String, Room> exits;

    public Room(String name) {
        this.name = name;
        this.exits = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addExit(String direction, Room room) {
        exits.put(direction.toLowerCase(), room);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public void displayRoom() {
        System.out.println("\nYou are in " + name + ".");
        System.out.println("Exits: ");

        for (String direction : exits.keySet()) {
            System.out .println("-> " + direction);
        }
    }
}