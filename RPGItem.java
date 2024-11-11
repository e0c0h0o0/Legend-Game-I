/**
 * The RPGItem class represents a generic item in the Legends RPG game.
 * Each RPGItem has a name, cost, and a required level (rqLvl) to be used by
 * heroes.
 * This class serves as a base class for more specific item types like weapons,
 * armor, potions, etc.
 */
public class RPGItem {
    protected String name;
    protected int cost;
    protected int rqLvl; // required level
    // default constructor

    public RPGItem() {
        name = "";
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getRqLvl() {
        return rqLvl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setRqLvl(int rqLvl) {
        this.rqLvl = rqLvl;
    }

}
