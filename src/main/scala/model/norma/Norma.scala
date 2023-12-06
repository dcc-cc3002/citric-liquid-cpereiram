package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

/** Represent a Norma State (or Level) in the game, which should be a PlayerCharacter's
 * value.
 *
 * A Norma can:
 * - Be checked.
 * - Have a starMode or victoryMode activate.
 *
 * FIELDS:
 * - starMode: Boolean
 * - starsRequired: Int
 * - victoriesRequired: Int
 *
 * @constructor Create a new Norma.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.3
 * @since 1.0
 */
trait Norma {

  //FIELDS
  /** Represent the activity of the norma mode.
   * If it's true, the starMode is active, otherwise, victoryMode is active.
   */
  protected val _starMode: Boolean

  /** Represent the amount of stars required to upgrade the norma.
   * If the starMode is active, this value is used, otherwise, victoriesRequired is used.
   */
  protected val _starsRequired: Int

  /** Represent the amount of victories required to upgrade the norma
   * If the starMode is inactive, this value is used, otherwise, starsRequired is used.
   */
  protected val _victoriesRequired: Int

  /** Represents the next norma of the character. */
  protected var _nextNorma: Norma


  //GETTERS
  /** Returns the activity of the norma mode.
   * If it's true, the starMode is active, otherwise, victoryMode is active.
   */
  def starMode: Boolean

  /** Returns the amount of stars required to upgrade the norma.
   * If the starMode is active, this value is used, otherwise, victoriesRequired is used.
   */
  def starsRequired: Int

  /** Returns the amount of victories required to upgrade the norma
   * If the starMode is inactive, this value is used, otherwise, starsRequired is used.
   */
  def victoriesRequired: Int

  /** Returns the next norma of the character. */
  def nextNorma: Norma

  //SETTERS
  /** Sets the next norma of the character. */
  def nextNorma_(newNorma: Norma): Unit

  //METHODS
  /** Checks the state of the current norma of a Player. */
  def check(character: PlayerCharacter): Boolean
}
