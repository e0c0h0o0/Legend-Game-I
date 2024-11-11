/**
 * The Creature class represents a basic entity in the game with attributes like
 * level,
 * health points (HP), and a name. Creatures can take damage, heal, level up,
 * and target other entities. The class also includes functionality to determine
 * whether the creature is dead or alive.
 */
public class Creature {
    protected int lvl;
    protected int hp;
    protected String name;
    // protected boolean isDead;
    protected int target;

    // default constructor
    public Creature() {
        name = "default";
        lvl = 1;
        hp = 100;
    }

    // constructor to set other attributes
    public Creature(int lvl, int hp, String name) {
        this.lvl = lvl;
        this.hp = hp;
        this.name = name;
    }

    // make a creature take damage
    public void takeDamage(int dmg) {
        hp -= dmg;
    }

    // make a creature gain health
    public void gainHealth(int health) {
        hp += health;
    }

    // return true if a creature is dead
    public boolean isDead() {
        return this.hp <= 0;
    }

    // make the creature go up a level
    public void lvlUp() {
        lvl++;
    }

    // getter/setters
    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getLvl() {
        return lvl;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setName(String name) {
        this.name = name;
    }
}
