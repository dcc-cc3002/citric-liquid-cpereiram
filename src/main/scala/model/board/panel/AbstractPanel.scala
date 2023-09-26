package cl.uchile.dcc.citric
package model.board.panel

import model.character.Character
import scala.collection.mutable.ArrayBuffer

/** An abstract class representing a Panel.
 *
 * Every Panel are represented by:
 *
 * @param characters List of characters currently on this panel. No one could be repeated.
 * @param nextPanels List of panels next to this current panel.
 *
 * @constructor Create a new Panel.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractPanel(val characters: ArrayBuffer[Character],
                             val nextPanels: ArrayBuffer[Panel])
  extends Panel {
  /// Documentation inherited from [[Panel]]
  override def addCharacter(player: Character): Unit = {
    characters += player
  }

  /// Documentation inherited from [[Panel]]
  override def removeCharacter(player: Character): Unit = {
    characters -= player
  }

  /// Documentation inherited from [[Panel]]
  override def addNextPanel(panel: Panel): Unit = {
    nextPanels += panel
  }

  /// Documentation inherited from [[Panel]]
  override def removeNextPanel(panel: Panel): Unit = {
    nextPanels -= panel
  }
}
