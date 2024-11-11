/**
 * The MonsterCreator interface defines a contract for creating Monster objects.
 * Classes that implement this interface must provide an implementation of the
 * `createMonster` method, which takes in character information and a level to
 * match.
 */
public interface MonsterCreator {
    // create a monster using a string and a level they need to be matched to
    Monster createMonster(String charInfo, int matchLvl);
}
