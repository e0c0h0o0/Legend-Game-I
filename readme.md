# Legends: Monsters and Heroes - RPG Game

## Overview

**Legends: Monsters and Heroes** is a turn-based RPG game set in a world of monsters and heroes. Players control a party of heroes and navigate through a game board filled with tiles that represent different terrains, such as wilderness, markets, and walls. Players can move, engage in battles with monsters, visit markets to buy or sell items, and use special abilities. The game is played on a grid-based map, and players must use strategy to level up their heroes and defeat monsters.

## How to Play

1. **Start the Game:**
   - The game begins with a welcome message, and the player is prompted to create a party of heroes.
   - Players can choose from different types of heroes (Warrior, Sorcerer, Paladin) and select from a list of predefined characters.
2. **Move Around the Board:**

   - The player controls their party's movement on the game board using specific keys:
     - `W`: Move up
     - `A`: Move left
     - `S`: Move down
     - `D`: Move right
   - Players can also access additional information and options:
     - `I`: Show hero information
     - `E`: Manage hero inventory
     - `M`: Display the game map
     - `Q`: Quit the game

3. **Market Interaction:**
   - When the player encounters a market, they can enter and choose to buy or sell items. Heroes can purchase weapons, armor, potions, and spells that improve their abilities in battle.
4. **Battles:**

   - Battles occur when the player encounters monsters in the wilderness or other regions. Players can attack, use spells, change equipment, or consume potions to survive the battle.
   - After defeating all the monsters, heroes receive rewards such as experience and money.

5. **Hero Inventory:**

   - Players can manage their heroes' inventory by equipping weapons and armor, using potions, or checking stats. Heroes can also sell items they no longer need.

6. **Winning and Leveling Up:**
   - After winning battles, heroes gain experience points and can level up, improving their stats such as health, mana, strength, agility, and dexterity.

## Game Classes

### Key Classes

- **`Hero` Class:**

  - Represents a hero in the game. It includes subclasses like `Warrior`, `Sorcerer`, and `Paladin`, each with different stat bonuses and abilities. Heroes can level up, equip items, and use spells.

- **`Monster` Class:**

  - Represents the different types of monsters encountered during the game, such as `Dragon`, `Exoskeleton`, and `Spirit`. Monsters have attributes like damage, defense, and dodge chance. They can attack, defend, and apply spell debuffs.

- **`RPGBoard` and `LegBoard` Classes:**

  - Represents the game board and its tile-based structure. It contains methods to initialize the board, check valid movements, and update the player’s position.

- **`Tile`, `MarketTile`, `WildTile`, and `WallTile`:**

  - Represents the different types of tiles on the board. WildTiles are walkable spaces, MarketTiles allow interaction with markets, and WallTiles are non-walkable obstacles.

- **`RPGItem`, `Weapon`, `Armor`, `Potion`, and `Spell`:**
  - Represents items that can be bought, sold, and used by heroes. Weapons and armor improve combat abilities, potions restore health or increase attributes, and spells deal damage or debuff enemies.

### Additional Classes

- **`MonsterFactory` and `HeroFactory`:**

  - Responsible for creating instances of monsters and heroes based on the player’s selection and character information.

- **`MonsterParty` and `RPGParty`:**

  - Manage groups of monsters and heroes, respectively, during battles. They track the status of each party member and manage their positions and inventory.

- **`Legends` Class:**
  - The main game logic class that handles the game loop, including player turns, market interactions, movement, and battle sequences.

## File Path Dependencies

Certain files in the game must be loaded from specific paths. Ensure that the following files are placed in the correct directories as referenced in `Legends.java`:

- **Warriors Data:** `Legends_Monsters_and_Heroes/Warriors.txt`
- **Sorcerers Data:** `Legends_Monsters_and_Heroes/Sorcerers.txt`
- **Paladins Data:** `Legends_Monsters_and_Heroes/Paladins.txt`
- **Dragons Data:** `Legends_Monsters_and_Heroes/Dragons.txt`
- **Exoskeletons Data:** `Legends_Monsters_and_Heroes/Exoskeletons.txt`
- **Spirits Data:** `Legends_Monsters_and_Heroes/Spirits.txt`
- **Weapons Data:** `Legends_Monsters_and_Heroes/Weaponry.txt`
- **Armor Data:** `Legends_Monsters_and_Heroes/Armory.txt`
- **Potions Data:** `Legends_Monsters_and_Heroes/Potions.txt`
- **Ice Spells Data:** `Legends_Monsters_and_Heroes/IceSpells.txt`
- **Fire Spells Data:** `Legends_Monsters_and_Heroes/FireSpells.txt`
- **Lightning Spells Data:** `Legends_Monsters_and_Heroes/LightningSpells.txt`

**Note:** Ensure the project structure includes a `Legends_Monsters_and_Heroes` directory at the root level where these text files are stored.

## Installation and Setup

1. **Prerequisites:**

   - Ensure that you have Java 8 or higher installed on your machine.

2. **Running the Game:**
   - Navigate to the project folder and compile the game:
     ```bash
     javac MainApp.java
     ```
   - Run the game using the following command:
     ```bash
     java MainApp
     ```

## Controls

- **Movement:** `W` (up), `A` (left), `S` (down), `D` (right)
- **Inventory:** `E` (manage inventory)
- **Info:** `I` (show hero info)
- **Map:** `M` (show map)
- **Quit:** `Q` (quit game)

---

Enjoy your adventure in **Legends: Monsters and Heroes**!
