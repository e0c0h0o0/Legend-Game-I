/**
 * The Spell class represents a magical spell in the Legends RPG game.
 * Each spell has attributes such as damage, mana cost, and type (e.g., Ice,
 * Fire, Lightning).
 * This class extends RPGItem, inheriting its name, cost, and required level
 * attributes.
 */
public class Spell extends RPGItem {
    private int dmg;
    private int manaCost;
    private Spells spellType;

    public Spell() {
        super();
    }

    // Sets the attributes of the spell based on the input string and the spell
    // type.
    // The input string should follow the format: Name cost requiredLevel damage
    // manaCost.
    public void setAttributes(String input, Spells spellType) {
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.dmg = Integer.parseInt(characterAttr[3]);
        this.manaCost = Integer.parseInt(characterAttr[4]);
        this.spellType = spellType;

    }

    // print weapon and info
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String spaces = "  ";
        str.append(this.name).append(spaces);
        str.append("Cost: ").append(this.cost).append(spaces);
        str.append("rqLVL: ").append(this.rqLvl).append(spaces);
        str.append("DMG: ").append(this.dmg).append(spaces);
        str.append("ManaCost: ").append(this.manaCost).append(spaces);
        return str.toString();
    }

    public int getDmg() {
        return dmg;
    }

    public int getManaCost() {
        return manaCost;
    }

    public Spells getSpellType() {
        return spellType;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public void setSpellType(Spells spellType) {
        this.spellType = spellType;
    }

}
