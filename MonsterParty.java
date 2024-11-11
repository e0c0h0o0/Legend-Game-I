/**
 * The MonsterParty class represents a group of monsters in the Legends game.
 * It provides methods for managing and interacting with a party of monsters,
 * including
 * determining which monsters are alive, printing the status of the monsters,
 * and adding or retrieving monsters.
 */
public class MonsterParty {
    // monster array to hold the monsters
    private Monster[] monsters;

    public MonsterParty() {

    }

    // generate a monster party of a specified size
    public MonsterParty(int num) {
        monsters = new Monster[num];
    }

    // print out all of the monsters that have not yet fainted
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("\nAlive Monsters:\n");
        for (Monster monster : monsters) {
            if (monster.getHp() > 0) {
                toPrint.append(monster).append("\n\n");
            }
        }
        return toPrint.toString();
    }

    // return true if every monster is dead
    public boolean allDead() {
        for (Monster monster : monsters) {
            if (!monster.isDead()) {
                return false;
            }
        }
        return true;
    }

    // number of monster still alive
    public int numAlive() {
        int count = 0;
        for (Monster monster : monsters) {
            if (!monster.isDead()) {
                count++;
            }
        }
        return count;
    }

    // return an array filled with the indexes of the living creatures
    public int[] aliveIndexes() {
        int[] alive = new int[numAlive()];
        int count = 0;
        for (int x = 0; x < monsters.length; x++) {
            if (!(monsters[x].isDead())) {
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    // get the length
    public int getLength() {
        return monsters.length;
    }

    // get a monster at an index
    public Monster getMonster(int index) {
        return monsters[index];
    }

    // set a monster at an index
    public void setMonster(int index, Monster mon) {
        monsters[index] = mon;
    }

}
