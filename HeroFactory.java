/**
 * The HeroFactory class is responsible for creating Hero objects of different
 * types.
 * This class uses the Factory design pattern to encapsulate the creation logic,
 * allowing for the creation of different Hero subclasses (Warrior, Sorcerer,
 * Paladin)
 * based on a provided input type.
 */
public class HeroFactory {
    // default constructor
    public HeroFactory() {

    }

    // a method to create a hero, input must be either 1,2,or 3 (aka warrior,
    // sorcerer, or paladin)
    public Hero createHero(int type) {
        Hero newHero;
        switch (type) {
            case 1:
                newHero = new Warrior();
                break;
            case 2:
                newHero = new Sorcerer();
                break;
            case 3:
                newHero = new Paladin();
                break;
            default: // default to a warrior
                newHero = new Warrior();
                break;
        }
        return newHero;
    }
}
