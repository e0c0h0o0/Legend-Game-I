/**
 * The Potion class represents a consumable item in the Legends game that can
 * boost
 * a hero's attributes (such as Health, Mana, Strength, Dexterity, or Agility).
 * Potions can be used during gameplay to increase specific hero attributes by a
 * defined amount.
 */
public class Potion extends RPGItem {
    private int attInc; // attribute increase
    private String attrAff; // attribute affected

    public Potion() {
        super();
    }

    // Name/cost/required level/attribute increase/attribute affected
    public void setAttributes(String input) {
        String[] characterAttr = input.split("\\s+");
        this.name = characterAttr[0];
        this.cost = Integer.parseInt(characterAttr[1]);
        this.rqLvl = Integer.parseInt(characterAttr[2]);
        this.attInc = Integer.parseInt(characterAttr[3]);
        this.attrAff = characterAttr[4];

    }

    // print weapon and info
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String spaces = "  ";
        str.append(this.name).append(spaces);
        str.append("Cost: ").append(this.cost).append(spaces);
        str.append("rqLVL: ").append(this.rqLvl).append(spaces);
        str.append("Potency: ").append(this.attInc).append(spaces);
        str.append("Affinities: ").append(this.attrAff).append(spaces);
        return str.toString();
    }

    // use a potion on the hero
    public void usePotion(Hero hero) {
        String[] affs = attrAff.split("/");
        for (String aff : affs) {
            switch (aff) {
                case "Health":
                    increaseHeroAttribute(hero, "Health", attInc);
                    break;
                case "Mana":
                    increaseHeroAttribute(hero, "Mana", attInc);
                    break;
                case "Strength":
                    increaseHeroAttribute(hero, "Strength", attInc);
                    break;
                case "Dexterity":
                    increaseHeroAttribute(hero, "Dexterity", attInc);
                    break;
                case "Agility":
                    increaseHeroAttribute(hero, "Agility", attInc);
                    break;
                case "All":
                    increaseHeroAttribute(hero, "Health", attInc);
                    increaseHeroAttribute(hero, "Mana", attInc);
                    increaseHeroAttribute(hero, "Strength", attInc);
                    increaseHeroAttribute(hero, "Dexterity", attInc);
                    increaseHeroAttribute(hero, "Agility", attInc);
                    break;
                default:
                    System.out.println("Unknown attribute affected: " + aff);
            }
        }
    }

    private void increaseHeroAttribute(Hero hero, String attribute, int amount) {
        switch (attribute) {
            case "Health":
                hero.setHp(hero.getHp() + amount);
                break;
            case "Mana":
                hero.setMana(hero.getMana() + amount);
                break;
            case "Strength":
                hero.setStrength(hero.getStrength() + amount);
                break;
            case "Dexterity":
                hero.setDexterity(hero.getDexterity() + amount);
                break;
            case "Agility":
                hero.setAgility(hero.getAgility() + amount);
                break;
        }
    }

    public int getAttInc() {
        return attInc;
    }

    public String getAttrAff() {
        return attrAff;
    }

    public void setAttInc(int attInc) {
        this.attInc = attInc;
    }

    public void setAttrAff(String attrAff) {
        this.attrAff = attrAff;
    }
}
