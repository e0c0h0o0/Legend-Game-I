/**
 * The Warrior class represents a type of hero in the Legends RPG game.
 * Warriors are physical combat-focused heroes with a special emphasis on
 * strength and agility,
 * making them more effective in melee combat. This class extends the Hero class
 * and implements
 * the HeroCreator interface, allowing for dynamic creation of Warrior heroes.
 */
public class Warrior extends Hero implements HeroCreator {
    public Warrior() {
        super();
    }

    public Warrior(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Warrior createHero(String charInfo) {
        Warrior newHero = new Warrior();
        setAttributes(charInfo);
        return newHero;
    }

    // same as hero but add 5 percent more to favored stats
    public void LvlUp() {
        lvl++;
        hp = lvl * 100;
        mana = (int) (mana * 1.1);
        // all skills go up 5 percent and 5 more to favored stats
        strength = (int) (strength * 1.05);
        agility = (int) (agility * 1.05);
        dexterity = (int) (dexterity * 1.10);
    }
}
