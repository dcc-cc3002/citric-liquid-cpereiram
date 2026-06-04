package cl.uchile.dcc.citric
package model.board.panel

import cl.uchile.dcc.citric.model.character.Character
import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
  * @version 1.3
  * @since 1.0
  */
trait Panel {

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[Character]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  val nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This might be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The character to add to this panel.
    */
  def addCharacter(player: Character): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This might be invoked when a player moves off this panel.
    *
    * @param player The character to remove from this panel.
    */
  def removeCharacter(player: Character): Unit

  /** Add a specific panel next to the current panel.
   *
   * @param panel The panel to add from the list.
   */
  def addNextPanel(panel: Panel): Unit

  /** Delete a specific panel, which is next to the current panel.
   *
   * @param panel The panel to remove from the list.
   */
  def removeNextPanel(panel: Panel): Unit

  /** Applies the effect of the panel to a character.
    *
    * This method is invoked when a character lands on this panel.
    *
    * @param character The character to apply the effect to.
    */
  def apply(character: Character): Unit
}
