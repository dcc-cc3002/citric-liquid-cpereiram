package cl.uchile.dcc.citric
package model.board.panel

import model.character.Character

import java.util.Objects
import scala.collection.mutable.ArrayBuffer
class DropPanel(characters: ArrayBuffer[Character],
                 nextPanels: ArrayBuffer[Panel])
  extends AbstractPanel(characters, nextPanels) with Equals {

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[DropPanel]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[DropPanel]
      characters.equals(other.characters) &&
        nextPanels.equals(other.nextPanels)
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[DropPanel], characters, nextPanels)
  }
}