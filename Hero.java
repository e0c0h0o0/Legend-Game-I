import java.util.ArrayList;

/**
 * The Hero class represents a playable character in the game with specific
 * attributes like strength,
 * dexterity, agility, mana, experience, and money. Heroes can equip weapons and
 * armor, use potions and spells,
 * and participate in combat, gaining experience and leveling up as the game
 * progresses.
 */
public class Hero extends Creature {
    // hero exclusive statss
    protected int strength;
    protected int dexterity;
    protected int agility;
    protected int mana;
    protected int exp;
    protected int money;
    protected ArrayList<Weapon> weapons;
    protected ArrayList<Armor> armor;
    protected ArrayList<Potion> potions;
    protected ArrayList<Spell> spells;
    protected Weapon equippedWeapon;
    protected Armor equippedArmor;

    public Hero() {
        super();
    }

    // constructor to add just attributes
    public Hero(int strength, int dex, int agl, int mana, int exp, int money) {
        super();
        this.strength = strength;
        this.dexterity = dex;
        this.agility = agl;
        this.mana = mana;
        this.exp = exp;
    }

    // constructor to make a completely custom hero
    public Hero(int lvl, int hp, String name, int strength, int dex, int agl, int mana, int exp, int money) {
        super(lvl, hp, name);
        this.strength = strength;
        this.dexterity = dex;
        this.agility = agl;
        this.mana = mana;
        this.exp = exp;
    }

    // print out a Hero's inventory
    public void printInv() {
        System.out.println("-----------");
        System.out.println("Hero " + name + "'s inventory");
        System.out.println("Weapons: ");
        if (weapons.size() > 0) {
            for (Weapon wpn : weapons) {
                System.out.println(wpn);
            }
        }
        System.out.println("Armor: ");
        if (armor.size() > 0) {
            for (Armor arm : armor) {
                System.out.println(arm);
            }
        }
        System.out.println("Potions: ");
        if (potions.size() > 0) {
            for (Potion pot : potions) {
                System.out.println(pot);
            }
        }
        System.out.println("Spells: ");
        if (spells.size() > 0) {
            for (Spell spl : spells) {
                System.out.println(spl);
            }
        }
    }

    // equip a specific piece of armor
    public void equipArmor(int armorIndex) {
        equippedArmor = armor.get(armorIndex);
        System.out.println("Equipped " + equippedArmor.getName());
    }

    // equip a specific weapon
    public void equipWeapon(int wpnIndex) {
        equippedWeapon = weapons.get(wpnIndex);
        System.out.println("Equipped " + equippedWeapon.getName());
    }

    // use a potion and then remove it
    public void usePotion(int potionIndex) {
        potions.get(potionIndex).usePotion(this);
        System.out.println("Used " + potions.get(potionIndex).getName());
        potions.remove(potionIndex);
    }

    // use a spell
    // return true if the hero has enough mana
    public boolean useSpell(int spellIndex) {
        // if the player has enough mana, then subtract it from the mana
        int manaCost = spells.get(spellIndex).getManaCost();
        if (this.mana >= manaCost) {
            this.mana = this.mana - manaCost;
            return true;
        }
        System.out.println("Not enough mana!");
        return false;

    }

    // print hero information and all their stats
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String spaces = "  ";

        if (isDead()) {
            str.append("DEAD "); // ADD RED TO DEAD PLAYERS
        }
        str.append(this.name).append(spaces);
        str.append("LV: ").append(this.lvl).append(spaces);
        str.append("HP: ").append(this.hp).append(spaces);
        str.append("Mana:").append(this.mana).append(spaces);
        str.append("Str: ").append(this.strength).append(spaces);
        str.append("Agl: ").append(this.agility).append(spaces);
        str.append("Dex: ").append(this.dexterity).append(spaces);
        str.append("Money: ").append(this.money).append(spaces);
        str.append("Exp: ").append(this.exp).append(spaces);
        str.append("Wpn: ").append(this.equippedWeapon.getName()).append(spaces);
        str.append("Armor: ").append(this.equippedArmor.getName()).append(spaces);
        return str.toString();
    }

    // set attributes according to the inputted string
    // example string: Sehanine_Monnbow 600 700 800 500 2500 8
    public void setAttributes(String input) {
        lvl = 1;
        hp = lvl * 100; // first set lvl and HP
        String[] characterAttr = input.split("\\s+");
        // array is in this format:
        // Name/mana/strength/agility/dexterity/starting/money/starting experience
        name = characterAttr[0];
        mana = Integer.parseInt(characterAttr[1]);
        strength = Integer.parseInt(characterAttr[2]);
        agility = Integer.parseInt(characterAttr[3]);
        dexterity = Integer.parseInt(characterAttr[4]);
        money = Integer.parseInt(characterAttr[5]);
        exp = Integer.parseInt(characterAttr[6]);
        // init other variables in here
        weapons = new ArrayList<Weapon>();
        armor = new ArrayList<Armor>();
        potions = new ArrayList<Potion>();
        spells = new ArrayList<Spell>();
        equippedWeapon = new Weapon();
        equippedArmor = new Armor();
    }

    // check if a hero has leveled up
    public boolean chkLvlUp() {
        return exp >= lvl * 10;
    }

    // upgrade their stats
    public void LvlUp() {
        lvl++;
        hp = lvl * 100;
        mana = (int) (mana * 1.1);
        // all skills go up 5 percent
        // favored skills go up 5 percent more so override this in individual hero
        // classes
        strength = (int) (strength * 1.05);
        agility = (int) (agility * 1.05);
        dexterity = (int) (dexterity * 1.05);
    }

    // method to calculate the amount of damage a hero does with a weapon
    public int calcWpDmg() {
        return (int) ((strength + equippedWeapon.getDmg()) * .05);
    }

    // method to calculate the dodge chance of the hero
    public int calcDodge() {
        return (int) ((agility) * .003);
    }

    // method to calculate the amount of damage a hero does with a spell
    public int calcSpellDmg(Spell spell) {
        return (int) (spell.getDmg() * (1 + dexterity / 10000.0));
    }

    // make the hero take damage
    public void takeDamage(int dmg) {
        int reducedDamage = dmg - (equippedArmor.getDmgRed() / 10);
        this.hp -= Math.max(reducedDamage, 0);
    }

    // getters / setters
    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public int getMana() {
        return mana;
    }

    public int getExp() {
        return exp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Weapon getEqpWeapon() {
        return equippedWeapon;
    }

    public void setWeapon(Weapon wpn) {
        equippedWeapon = wpn;
    }

    public Armor getEqpArmor() {
        return equippedArmor;
    }

    public void setArmor(Armor arm) {
        equippedArmor = arm;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }
}
