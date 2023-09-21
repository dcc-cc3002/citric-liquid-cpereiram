package cl.uchile.dcc.citric
package citric

import scala.collection.mutable.ArrayBuffer

/** Represent a board in the game, where you can play.
 *
 * A board its made of all kind of Panels, which are connected to each other.
 * It also have a list of players.
 *
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 */
trait Board {
  /** A list of players on the game.
   *
   * In the board, must be other players interacting.
   */
  val charactersOnBoard: List[PlayerCharacter]

  /** Array with all the Panels available in the current game. */
  val panels: ArrayBuffer[Panel]
}
