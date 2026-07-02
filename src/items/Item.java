package items;

public abstract class Item implements Usable{
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}