package cl.uchile.dcc.citric
package model.board.panel

import model.character.{Character, PlayerCharacter}

import java.util.Objects
import scala.collection.mutable.ArrayBuffer

class BonusPanel(characters: ArrayBuffer[Character],
                  nextPanels: ArrayBuffer[Panel])
  extends AbstractPanel(characters, nextPanels) with Equals {

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[BonusPanel]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[BonusPanel]
      characters.equals(other.characters) &&
        nextPanels.equals(other.nextPanels)
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[BonusPanel], characters, nextPanels)
  }

  /// Documentation inherited from [[Panel]]
  override def apply(character: PlayerCharacter): Unit = {

  }
}
