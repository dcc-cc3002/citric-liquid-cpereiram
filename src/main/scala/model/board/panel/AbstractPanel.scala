package cl.uchile.dcc.citric
package model.board.panel

import model.character.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

abstract class AbstractPanel(override val characters: ArrayBuffer[PlayerCharacter],
                             override var nextPanels: ArrayBuffer[Panel])
  extends Panel {
  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  override def addCharacter(player: PlayerCharacter): Unit = {
    characters += player
  }

  override def removeCharacter(player: PlayerCharacter): Unit = {
    characters -= player
  }
}
