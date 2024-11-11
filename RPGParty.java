/**
 * The RPGParty class represents a group of heroes that form the player's party
 * in the Legends RPG game.
 * This class manages the party members, their positions on the board, and their
 * status during and after battles.
 */
public class RPGParty {
    private final int defaultPartyLocX = 0;
    private final int defaultPartyLocY = 0;
    private Hero[] playerParty;
    // current location of the party
    private int locationX;
    private int locationY;

    // constructor to specify number of players
    public RPGParty(int num) {
        playerParty = new Hero[num];
        locationX = defaultPartyLocX;
        locationY = defaultPartyLocY;
    }

    // method to get a Hero at an index
    public Hero getIndex(int index) {
        return playerParty[index];
    }

    // set a hero at an index
    public void setIndex(int index, Hero hero) {
        playerParty[index] = hero;
    }

    // print everyone's inventory
    public void printTeamInv() {
        for (int x = 0; x < playerParty.length; x++) {
            playerParty[x].printInv();
        }

    }

    // revive the dead members after the battle
    public void reviveTeam() {
        for (Hero hero : playerParty) {
            if (hero.isDead()) {
                int revivedHp = hero.getLvl() * 100 / 2;
                hero.setHp(Math.min(revivedHp, hero.getLvl() * 100)); // resurrection
            }
        }
    }

    // award the heroes for winning
    public void winBattle() {
        int highestLvl = getHighestLvl();
        for (Hero hero : playerParty) {
            if (!hero.isDead()) {
                hero.setExp(hero.getExp() + 2); // Increased experience
                hero.setMoney(hero.getMoney() + highestLvl * 100); // Reward money
                recoverHero(hero); // Restores some life and mana
            }
        }
    }

    private void recoverHero(Hero hero) {
        hero.setHp(hero.getHp() + (hero.getHp() / 10)); // 10% HP restoration
        hero.setMana(hero.getMana() + (hero.getMana() / 10)); // 10% restoration of Mana
    }

    // go through each character and check for level up
    public void chkLevelUp() {
        for (int x = 0; x < playerParty.length; x++) {
            // if the player is eligible to lvlup, do that
            if (playerParty[x].chkLvlUp()) {
                playerParty[x].LvlUp();
            }
        }
    }

    // override the toString method for when we print
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("\nYour current party:\n");
        for (Hero hero : playerParty) {
            toPrint.append(hero).append("\n\n");
        }
        return toPrint.toString();
    }

    // return true if every hero is dead
    public boolean allDead() {
        for (Hero hero : playerParty) {
            if (!hero.isDead()) {
                return false;
            }
        }
        return true;
    }

    // get the number of heros that are still alive
    public int numAlive() {
        int count = 0;
        for (Hero hero : playerParty) {
            if (!hero.isDead()) {
                count++;
            }
        }
        return count;
    }

    // return an array filled with the indexes of the living creatures
    public int[] aliveIndexes() {
        int[] alive = new int[numAlive()];
        int count = 0;
        for (int x = 0; x < playerParty.length; x++) {
            if (!(playerParty[x].isDead())) {
                alive[count] = x;
                count++;
            }
        }
        return alive;
    }

    // set the party's new position
    public void setPos(int x, int y) {
        locationX = x;
        locationY = y;
    }

    // get length of the party
    public int getLength() {
        return playerParty.length;
    }

    // get the highest level in the party
    public int getHighestLvl() {
        int highestLvl = 0;
        for (int x = 0; x < playerParty.length; x++) {
            if (playerParty[x].getLvl() > highestLvl) {
                highestLvl = playerParty[x].getLvl();
            }
        }
        return highestLvl;
    }

    // getters and setters
    public int getXLoc() {
        return locationX;
    }

    public int getYLoc() {
        return locationY;
    }

    public void setXLoc(int locationX) {
        this.locationX = locationX;
    }

    public void setYLoc(int locationY) {
        this.locationY = locationY;
    }

}
