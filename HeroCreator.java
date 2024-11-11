/**
 * The HeroCreator interface defines a contract for creating Hero objects.
 * Classes that implement this interface are responsible for providing the
 * implementation
 * of the `createHero` method, which takes in character information in the form
 * of a string
 * and returns a fully initialized Hero object.
 */
public interface HeroCreator {
    Hero createHero(String charInfo);
}
