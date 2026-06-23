package cl.uchile.dcc.citric
package model.character

import java.util.Objects

/** An abstract class representing a Character.
 *
 * Every Character are represented by:
 *
 * @param name The name of the player. This is an identifier and should be unique.
 * @param maxHp The maximum health points a player can have. It represents the player's endurance.
 * @param hp The current health points of a character.
 * @param attack The player's capability to deal damage to opponents.
 * @param defense The player's capability to resist or mitigate damage from opponents.
 * @param evasion The player's skill to completely avoid certain attacks.
 * @param ko Indicates if a character is Knockout.
 *
 * @constructor Create a new Character.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractCharacter(val name: String,
                                 val maxHp: Int,
                                 var hp: Int,
                                 var attack: Int,
                                 var defense: Int,
                                 var evasion: Int,
                                 var ko: Boolean)
  extends Character with Equals {

  /// Documentation inherited from [[Character]]
  override def receiveDamage(damage: Int): Unit = {
    var health: Int = hp - damage
    if (health < 0) {
      health = 0
    }
    hp = health
  }

  /// Documentation inherited from [[Character]]
  override def doDamage(other: Character, damage: Int): Unit = {
    var health: Int = other.hp - damage
    if (health < 0) {
      health = 0
    }
    other.hp = health
  }

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractCharacter]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractCharacter]
      name == other.name &&
      maxHp == other.maxHp &&
      hp == other.hp &&
      attack == other.attack &&
      defense == other.defense &&
      evasion == other.evasion &&
      ko == other.ko
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[AbstractCharacter],
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      ko)
  }
}
