package cl.uchile.dcc.citric
package model.character

import cl.uchile.dcc.citric.model.norma.Norma

import java.util.Objects
import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
 * several attributes such as health points, attack strength, defense capability,
 * and evasion skills. Each player has a unique name, and throughout the game,
 * players can collect stars, roll dice, and progress in levels known as 'norma'.
 * This class not only maintains the state of a player but also provides methods
 * to modify and interact with these attributes.
 *
 * For instance, players can:
 *
 * - Increase or decrease their star count.
 *
 * - Roll a dice, a common action in many board games.
 *
 * - Advance their norma level.
 *
 * Furthermore, the `Player` class has a utility for generating random numbers,
 * which is primarily used for simulating dice rolls. By default, this utility is
 * an instance of the `Random` class but can be replaced if different random
 * generation behaviors are desired.
 *
 * @param name The name of the player. This is an identifier and should be unique.
 * @param maxHp The maximum health points a player can have. It represents the player's endurance.
 * @param hp The current health points of a character.
 * @param attack The player's capability to deal damage to opponents.
 * @param defense The player's capability to resist or mitigate damage from opponents.
 * @param evasion The player's skill to completely avoid certain attacks.
 * @param stars The current stars a character have.
 * @param norma The current norma of the character.
 * @param victories The current victories a character have.
 * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
 *                              instance.
 *
 * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
 * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
 * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
 * @author [[https://github.com/Seivier/ Vicente González B.]]
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 */
class PlayerCharacter( name: String,
                       maxHp: Int,
                       override protected var _hp: Int,
                       override protected var _attack: Int,
                       override protected var _defense: Int,
                       override protected var _evasion: Int,
                       protected var _norma: Norma,
                       stars: Int,
                       protected var _victories: Int,
                       protected val randomNumberGenerator: Random = new Random())
  extends AbstractCharacter(name,
                            maxHp,
                            stars) with Equals{

  //GETTERS
  /** Returns the current norma of the character. */
  def norma: Norma = _norma

  /** Returns the current victories a character have. */
  def victories: Int = _victories


  //SETTERS
  /** Sets the current norma of the character. */
  def norma_(newNorma: Norma): Unit = {
    _norma = newNorma
  }

  /** Sets the current victories a character have. */
  def victories_(newVictories: Int): Unit = {
    _victories = newVictories
  }


  //EQUALS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[PlayerCharacter]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[PlayerCharacter]
        name == other.name &&
        maxHp == other.maxHp &&
        hp == other.hp &&
        attack == other.attack &&
        defense == other.defense &&
        evasion == other.evasion &&
        norma == other.norma &&
        stars == other.stars &&
        victories == other.victories
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[PlayerCharacter],
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma,
      stars,
      victories)
  }


  //METHODS
  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** Checks if the character has achieved the norma.
   * @return true if the character has achieved the norma, false otherwise.
   * */
  def normaCheck(): Boolean = {
    norma.check(this)
  }

  override def toAttack(): Unit = ???

  override def toDefend(): Unit = ???

  override def toEvade(): Unit = ???


}
