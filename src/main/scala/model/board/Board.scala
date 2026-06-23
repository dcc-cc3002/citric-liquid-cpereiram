package cl.uchile.dcc.citric
package model.board

import cl.uchile.dcc.citric.model.board.panel.Panel
import cl.uchile.dcc.citric.model.character.PlayerCharacter

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
