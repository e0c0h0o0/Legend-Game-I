/**
 * The MonsterFactory class is responsible for creating Monster objects of
 * various types.
 * It uses the Factory design pattern to encapsulate the logic for creating
 * different
 * types of monsters (Dragon, Exoskeleton, Spirit) based on input parameters.
 */
public class MonsterFactory {
    public MonsterFactory() {

    }

    public Monster createMonster(int type, String info, int targetLvl) {
        Monster newMonster;
        switch (type) {
            case 1:
                newMonster = new Dragon();
                break;
            case 2:
                newMonster = new Exoskeleton();
                break;
            case 3:
                newMonster = new Spirit();
                break;
            default: // default to a dragon
                newMonster = new Dragon();
                break;
        }
        // set attributes
        newMonster.setAttributes(info);
        // match target level
        newMonster.matchLevel(targetLvl);
        return newMonster;
    }
}
