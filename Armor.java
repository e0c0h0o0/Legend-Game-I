/**
 * The Armor class represents an armor item in the role-playing game (RPG).
 * Armor is a type of RPGItem that reduces damage in battles.
 * This class extends the RPGItem base class and adds functionality specific to
 * armor,
 * such as damage reduction.
 */
public class Armor extends RPGItem {
    private int dmgRed;

    public Armor() {
        super();
        dmgRed = 0;
    }

    // Name/Cost/Required Level/Damage Reduction
    // Platinum_Shield 150 1 200
    public void setAttributes(String input) {
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmgRed = Integer.parseInt(characterAttr[3]);
    }

    // print weapon and info
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String spaces = "  ";
        str.append(this.name).append(spaces);
        str.append("Cost: ").append(this.cost).append(spaces);
        str.append("rqLVL: ").append(this.rqLvl).append(spaces);
        str.append("dmgRed: ").append(this.dmgRed).append(spaces);
        return str.toString();
    }

    public int getDmgRed() {
        return dmgRed;
    }

    public void setDmgRed(int dmgRed) {
        this.dmgRed = dmgRed;
    }
}
