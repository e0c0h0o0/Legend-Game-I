/**
 * The Spirit class represents a specific type of monster in the Legends RPG
 * game.
 * Spirits are ethereal enemies with unique attributes like base damage,
 * defense, and dodge chance.
 * This class extends the Monster class and implements the MonsterCreator
 * interface.
 */
public class Spirit extends Monster implements MonsterCreator {
    public Spirit() {
        super();
    }

    // create a Spirit with all set attributes
    public Spirit(int lvl, int hp, String name, int baseDMG, int defense, int dodgeChance) {
        super(lvl, hp, name, baseDMG, defense, dodgeChance);
    }

    // create a new spirit and match it to the correct level
    public Spirit createMonster(String charInfo, int matchLvl) {
        Spirit spirit = new Spirit();
        spirit.setAttributes(charInfo);
        spirit.matchLevel(matchLvl);
        return spirit;
    }

}
