package cl.uchile.dcc.citric
package model.character

import model.Norma

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
 * @version 1.3
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

  /** Indicates if a character is Knockout. */
  protected var _ko: Boolean

  /** The norma of a Character. */
  protected var _norma: Norma

  //GETTERS
  /** Returns the name of the character. */
  def name: String = _name

  /** Returns the maxHp of the character. */
  def maxHp: Int = _maxHp

  /** Returns the current HP of the character. */
  def hp: Int = _hp

  /** Returns the current attack stat of the character. */
  def attack: Int = _attack

  /** Returns the current defense stat of the character. */
  def defense: Int = _defense

  /** Returns the current evasion stat of the character. */
  def evasion: Int = _evasion

  /** Returns the state of the character. */
  def ko: Boolean = _ko

  /** Returns the current norma of the character. */
  def norma: Norma = _norma

  //METHODS
  /** A character can get damage. */
  def receiveDamage(damage: Int): Unit

  /** A character can do damage. */
  def doDamage(other: Character, damage: Int): Unit
}
