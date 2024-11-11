/**
 * The Monster class represents a monster in the Legends game.
 * Monsters have attributes such as base damage, defense, and dodge chance,
 * and can participate in battles by attacking heroes and taking damage.
 * This class extends the Creature class, inheriting common attributes like
 * level, health, and name.
 */
public class Monster extends Creature {
    protected int baseDMG;
    protected int defense;
    protected int dodgeChance;

    // default constructor
    public Monster() {

    }

    // create a monster with all new attributes
    public Monster(int baseDMG, int defense, int dodgeChance) {
        this(1, 100, "Default", baseDMG, defense, dodgeChance);
    }

    // create a monster and set all its stats
    public Monster(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance) {
        super(lvl, hp, name);
        this.baseDMG = baseDMG;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
    }

    // override toString
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        String spaces = "  ";
        toPrint.append(getClass().getSimpleName()).append(spaces);
        toPrint.append(name).append(spaces);
        toPrint.append("LVL: ").append(lvl).append(spaces);
        toPrint.append("HP: ").append(hp).append(spaces);
        toPrint.append("DMG: ").append(baseDMG).append(spaces);
        toPrint.append("DEF: ").append(defense).append(spaces);
        toPrint.append("DODGE: ").append(dodgeChance).append(spaces);
        return toPrint.toString();
    }

    // helper methods,set each attribute based on the inputted string from the file
    // Desghidorrah 3 300 400 35
    public void setAttributes(String input) {
        // split off of any white space
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.lvl = Integer.parseInt(characterAttr[1]);
        this.baseDMG = Integer.parseInt(characterAttr[2]);
        this.defense = Integer.parseInt(characterAttr[3]);
        this.dodgeChance = Integer.parseInt(characterAttr[4]);
        // set hp
        this.hp = lvl * 100;
    }

    // make it so the monster is on the same level as the highest level hero in the
    // party
    public void matchLevel(int newLvl) {
        double scalingFactor = (double) newLvl / this.lvl;
        this.lvl = newLvl;
        this.hp = newLvl * 100;
        this.baseDMG = (int) (this.baseDMG * scalingFactor);
        this.defense = (int) (this.defense * scalingFactor);
    }

    // method to do the debuff from a spell
    public void spellDebuff(Spell spell) {
        double debuffFactor = 0.1;
        switch (spell.getSpellType()) {
            case ICE:
                applyDebuffToBaseDMG(debuffFactor);
                break;
            case FIRE:
                applyDebuffToDefense(debuffFactor);
                break;
            case LIGHTNING:
                applyDebuffToDodgeChance(debuffFactor);
                break;
        }

    }

    private void applyDebuffToBaseDMG(double factor) {
        this.baseDMG = this.baseDMG - (int) (this.baseDMG * factor);
    }

    private void applyDebuffToDefense(double factor) {
        this.defense = this.defense - (int) (this.defense * factor);
    }

    private void applyDebuffToDodgeChance(double factor) {
        this.dodgeChance = this.dodgeChance - (int) (this.dodgeChance * factor);
    }

    // method to calculate the amount of damage
    public int calcDmg() {
        return (int) (this.baseDMG * .15);
    }

    // method to calculate the dodge chance of the hero
    public int calcDodge() {
        return (int) (dodgeChance * .01);
    }

    // take damage and subtract defense
    public void takeDamage(int dmg) {
        int actualDamage = dmg - (defense / 100);
        this.hp = this.hp - Math.max(actualDamage, 0);
    }

    // setters / getters
    public int getBaseDMG() {
        return baseDMG;
    }

    public int getDefense() {
        return defense;
    }

    public int getDodgeChance() {
        return dodgeChance;
    }

    public void setBaseDMG(int baseDMG) {
        this.baseDMG = baseDMG;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDodgeChance(int dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

}
