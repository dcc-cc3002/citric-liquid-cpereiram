package cl.uchile.dcc.citric
package model.norma

/** Represent a Norma State (or Level) in the game, which should be a PlayerCharacter's
 * value.
 *
 * A Norma can:
 * - Be checked.
 * - Have a starMode or victoryMode activate.
 *
 * @constructor Create a new Norma.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.2
 * @since 1.0
 */
trait Norma {
  /** Represent the activity of the norma mode.
   * If it's true, the starMode is active, otherwise, victoryMode is active.
   */
  protected val _starMode: Boolean

  /** Returns the activity of the norma mode.
   * If it's true, the starMode is active, otherwise, victoryMode is active.
   */
  def starMode: Boolean

  /** Check the current state of the norma.
   *
   * @return true if the norma is ready, false otherwise.
   */
  def NormaCheck(): Boolean
}
