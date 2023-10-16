package cl.uchile.dcc.citric
package model.character

import cl.uchile.dcc.citric.model.norma.Norma

/** Represent a Character in the game, who should be a player or a Wild Unit, .
 *
 * A character is represented with a name, a maximum amount of HP, a current amount
 * of HP, numbers that represents its attack, defense, evasion and a variable state
 * if a character is knockout.
 *
 * A character can:
 * - Attack other Characters.
 * - Be attacked by another Characters.
 * - Be knocked out by a Character.
 *
 * @constructor Create a new Character.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.4
 * @since 1.0
 */
trait Character {
  //FIELDS
  /** Represents the name of the character. */
  protected val _name: String

  /** Max hit points that a Character will have. */
  protected val _maxHp: Int

  /** Current hit point of a character.*/
  protected var _hp: Int

  /** Attack stat of a Character. */
  protected var _attack: Int

  /** Defense stat of a Character. */
  protected var _defense: Int

  /** Evasion stat of a Character. */
  protected var _evasion: Int

  //GETTERS
  /** Returns the name of the character. */
  def name: String

  /** Returns the maxHp of the character. */
  def maxHp: Int

  /** Returns the current HP of the character. */
  def hp: Int

  /** Returns the current attack stat of the character. */
  def attack: Int

  /** Returns the current defense stat of the character. */
  def defense: Int

  /** Returns the current evasion stat of the character. */
  def evasion: Int

  //METHODS
  /** A character can get damage. */
  def receiveDamage(damage: Int): Unit

  /** A character can do damage. */
  def doDamage(other: Character, damage: Int): Unit

  /** Method that returns the state of the character. */
  def isKo(): Boolean

  def toAttack(): =
  {
    // Código para el ataque
  }

  def toDefend():
  ...=
  {
    // Código para defender
  }

  def toEvade():
  ...=
  {
    // Código para evadir
  }
}
