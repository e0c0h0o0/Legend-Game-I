/**
 * The Weapon class represents a weapon item in the Legends RPG game.
 * Each weapon has attributes such as damage and required hands to use it
 * effectively.
 * This class extends RPGItem, inheriting its basic attributes such as name,
 * cost, and required level.
 */
public class Weapon extends RPGItem {
    private int dmg;
    private int rqHands;

    public Weapon() {
        super();
        dmg = 0;
    }

    // ex: Name/cost/level/damage/required hands
    // Sword 500 1 800 1
    public void setAttributes(String input) {
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmg = Integer.parseInt(characterAttr[3]);
        this.rqHands = Integer.parseInt(characterAttr[4]);

    }

    // print weapon and info
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String spaces = "  ";
        str.append(this.name).append(spaces)
                .append("Cost: ").append(this.cost).append(spaces)
                .append("rqLVL: ").append(this.rqLvl).append(spaces)
                .append("DMG: ").append(this.dmg).append(spaces)
                .append("rqHANDS: ").append(this.rqHands).append(spaces);
        return str.toString();
    }

    public int getDmg() {
        return dmg;
    }

    public int getRqHands() {
        return rqHands;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setRqHands(int rqHands) {
        this.rqHands = rqHands;
    }
}
