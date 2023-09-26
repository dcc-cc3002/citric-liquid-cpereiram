package cl.uchile.dcc.citric
package model.board.panel
import model.character.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanel extends Panel {
  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  override val characters: ArrayBuffer[PlayerCharacter] = ???
  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  override var nextPanels: ArrayBuffer[Panel] = ???

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  override def addCharacter(player: PlayerCharacter): Unit = ???

  /** Removes a character from the list of characters currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  override def removeCharacter(player: PlayerCharacter): Unit = ???
}
