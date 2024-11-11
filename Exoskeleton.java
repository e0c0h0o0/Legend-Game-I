/**
 * The Exoskeleton class represents a specific type of Monster in the game.
 * Exoskeletons have attributes such as level, health points, base damage,
 * defense, and dodge chance.
 * This class extends the Monster class and implements the MonsterCreator
 * interface,
 * allowing for the creation and customization of Exoskeleton instances.
 */
public class Exoskeleton extends Monster implements MonsterCreator {
    public Exoskeleton() {
        super();
    }

    // create a Exoskeleton with all set attributes
    public Exoskeleton(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance) {
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }

    // create a new Exoskeleton and match it to the correct level
    public Exoskeleton createMonster(String charInfo, int matchLvl) {
        Exoskeleton exoskeleton = new Exoskeleton();
        exoskeleton.setAttributes(charInfo);
        exoskeleton.matchLevel(matchLvl);
        return exoskeleton;
    }

}
