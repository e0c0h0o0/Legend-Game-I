/**
 * The Dragon class represents a specific type of Monster in the game.
 * Dragons have attributes such as level, health points, base damage, defense,
 * and dodge chance.
 * This class extends the Monster class and implements the MonsterCreator
 * interface,
 * allowing for the creation and customization of Dragon instances.
 */
public class Dragon extends Monster implements MonsterCreator {
    public Dragon() {
        super();
    }

    // create a dragon with all set attributes
    public Dragon(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance) {
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }

    // create a new dragon and match it to the correct level
    public Dragon createMonster(String charInfo, int matchLvl) {
        Dragon dragon = new Dragon();
        dragon.setAttributes(charInfo);
        dragon.matchLevel(matchLvl);
        return dragon;
    }

}
