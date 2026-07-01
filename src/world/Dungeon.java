package world;

public class Dungeon {
    private Room entrance;
    private Room armory;
    private Room treasure;

    public Dungeon() {
        entrance = new Room("Entrance Hall");
        armory = new Room("Armory");
        treasure = new Room("Treasure Room");

        entrance.addExit("north", armory);

        armory.addExit("south", entrance);
        armory.addExit("east", treasure);

        treasure.addExit("west", armory);
    }
    public Room getStartingRoom() {
        return entrance;
    }
}
