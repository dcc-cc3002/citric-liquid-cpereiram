package cl.uchile.dcc.citric
package model.board.panel

import model.character.{Character, PlayerCharacter}

import java.util.Objects
import scala.collection.mutable.ArrayBuffer

/**
 * A panel that represents the home of a player.
 *
 * Here the player begins the game.
 * If the owner fall in this panel, can choose to stay or leave.
 * If the player isn't the owner, the player can't stay in this panel, must fall
 * right on it.
 *
 * Been active, the players heal their HP up and the panel will do an NormaCheck
 *
 * @param characters the characters that are currently in the panel.
 * @param nextPanels the panels that can be reached from this panel.
 * @param _owner the player that owns this home panel.
 */
class HomePanel(characters: ArrayBuffer[Character],
                nextPanels: ArrayBuffer[Panel],
                private val _owner: PlayerCharacter)
  extends AbstractPanel(characters, nextPanels) with Equals {

  //GETTERS
  /** Returns the owner of the HomaPanel. */
  def owner: PlayerCharacter = _owner

  //EQUALS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[HomePanel]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[HomePanel]
      characters.equals(other.characters) &&
        nextPanels.equals(other.nextPanels) &&
        owner.equals(other.owner)
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[HomePanel], characters, nextPanels, owner)
  }

  /// Documentation inherited from [[Panel]]
  override def apply(character: PlayerCharacter): Unit = {
    character.hp_(character.maxHp) //heal the player
    if (character == owner && character.normaCheck()) {
      character.norma_(character.norma.nextNorma)
    }
  }
}
