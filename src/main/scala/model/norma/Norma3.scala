package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import java.util.Objects

/** A norma that requires 70 stars or 6 victories to be achieved, depending on the mode.
 *
 * @param starMode Whether the norma is star-based or victory-based.
 *
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
class Norma3(starMode: Boolean) extends AbstractNorma(starMode: Boolean) with Equals{
  //FIELDS
  override protected val _starsRequired: Int = 70
  override protected val _victoriesRequired: Int = 6
  override protected var _nextNorma: Norma = new Norma4(starMode)


  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def nextNorma: Norma = _nextNorma

  //SETTERS
  /// Documentation inherited from [[Norma]]
  def nextNorma_(newNorma: Norma4): Unit = {
    _nextNorma = newNorma
  }

  //EQUALS METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Norma3]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Norma3]
      starMode == other.starMode &&
        starsRequired == other.starsRequired &&
        victoriesRequired == other.victoriesRequired
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[Norma3],
      starMode)
  }
}