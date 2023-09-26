package cl.uchile.dcc.citric
package model.character

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
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 */
trait Character {
  /* Represents the name of the character. */
  val name: String

  /* Max hit points that a Character will have. */
  val hpMax: Int

  /* Current hit point of a character.*/
  var hp: Int

  /* Attack stat of a Character. */
  var attack: Int

  /* Defense stat of a Character. */
  var defense: Int

  /* Evasion stat of a Character. */
  var evasion: Int

  /* Indicates if a character is Knockout. */
  var ko: Boolean

  /* A character can get damage. */
  def receiveDamage(damage: Int): Unit

  /* A character can do damage. */
  def doDamage(damage: Int): Unit
}
