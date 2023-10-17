package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.character.PlayerCharacter

import java.util.Objects

/**
 * Abstract class for Norma.
 *
 * @param starMode Represent the activity of the norma mode.
 * @constructor Create a new Norma.
 *              This class is abstract, so it can't be instantiated.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
abstract class AbstractNorma(val _starMode: Boolean)
  extends Norma with Equals {
  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def starMode: Boolean = _starMode

  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[AbstractNorma]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[AbstractNorma]
      starMode == other.starMode
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[AbstractNorma],
      starMode)
  }

  /// Documentation inherited from [[Norma]]
  override def NormaCheck(p: PlayerCharacter): Boolean = {
    if (starMode) {
      if (p.stars >= 6) {
        true
      } else {
        false
      }
    } else {
      if (wins >= 5) {
        true
      } else {
        false
      }
    }
  }
}
