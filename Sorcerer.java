/**
 * The Sorcerer class represents a type of hero in the Legends RPG game.
 * Sorcerers are magic-focused heroes with a special emphasis on agility and
 * dexterity,
 * making them more effective at casting spells and avoiding attacks.
 * This class extends the Hero class and implements the HeroCreator interface.
 */
public class Sorcerer extends Hero implements HeroCreator {
    public Sorcerer() {
        super();
    }

    public Sorcerer(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Sorcerer createHero(String charInfo) {
        Sorcerer newHero = new Sorcerer();
        setAttributes(charInfo);
        return newHero;
    }

    // Levels up the Sorcerer, increasing stats with special emphasis on agility and
    // dexterity.
    public void LvlUp() {
        lvl++;
        hp = lvl * 100;
        mana = (int) (mana * 1.1);
        // all skills go up 5 percent and 5 more to favored stats
        strength = (int) (strength * 1.10);
        agility = (int) (agility * 1.10);
        dexterity = (int) (dexterity * 1.05);
    }
}
