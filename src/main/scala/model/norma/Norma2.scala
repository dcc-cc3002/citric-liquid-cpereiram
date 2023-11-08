package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import java.util.Objects

/** A norma that requires 30 stars or 3 victories to be achieved, depending on the mode.
 *  @param starMode Whether the norma is star-based or victory-based.
 *
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
class Norma2(starMode: Boolean) extends AbstractNorma(starMode: Boolean) with Equals{
  //FIELDS
  override protected val _starsRequired: Int = 30
  override protected val _victoriesRequired: Int = 3
  override protected var _nextNorma: Norma3 = new Norma3(starMode)


  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def nextNorma: Norma3 = _nextNorma

  //SETTERS
  /// Documentation inherited from [[Norma]]
  def nextNorma_(newNorma: Norma3): Unit = {
    _nextNorma = newNorma
  }

  //EQUALS METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Norma2]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Norma2]
      starMode == other.starMode &&
        starsRequired == other.starsRequired &&
        victoriesRequired == other.victoriesRequired
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[Norma2],
      starMode)
  }
}