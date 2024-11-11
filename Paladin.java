/**
 * The Paladin class represents a Paladin hero in the Legends game.
 * Paladins are a subclass of Hero, and their favored stats (strength and
 * dexterity)
 * increase more significantly when they level up. This class implements the
 * HeroCreator interface,
 * allowing for the creation of Paladin objects.
 */
public class Paladin extends Hero implements HeroCreator {
    public Paladin() {
        super();
    }

    public Paladin(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name, strength, dex, agl, mana, exp, money);
    }

    public Paladin createHero(String charInfo) {
        Paladin newHero = new Paladin();
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
        agility = (int) (agility * 1.10);
        dexterity = (int) (dexterity * 1.10);
    }

}
