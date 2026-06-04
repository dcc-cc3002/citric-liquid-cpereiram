package cl.uchile.dcc.citric
package model.norma
import model.character.PlayerCharacter

import java.util.Objects

class Norma1(val _starMode: Boolean) extends Norma with Equals {
  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def starMode: Boolean = _starMode

  //EQUALS METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Norma1]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Norma1]
      starMode == other.starMode
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[Norma1],
      starMode)
  }

  /** Check the current state of the norma.
   *
   * @return true if the norma is ready for the next level, false otherwise.
   */
  override def normaCheck(p: PlayerCharacter): Boolean = {
    if (starMode) {
      p.stars >= 10
    } else {
      p.victories >= 1
    }
  }

}
