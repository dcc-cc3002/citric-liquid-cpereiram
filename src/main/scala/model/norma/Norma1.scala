package cl.uchile.dcc.citric
package model.norma


import java.util.Objects

/** The Norma1 is norma that requires 10 stars or 1 victory to be achieved,
 * depending on the mode.
 *
 * The next norma is Norma2.
 *
 *  @param starMode Whether the norma is star-based or victory-based.
 *
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.1
 * @since 1.0
 */
class Norma1(starMode: Boolean) extends AbstractNorma(starMode: Boolean) with Equals {
  //FIELDS
  override protected val _starsRequired: Int = 10
  override protected val _victoriesRequired: Int = 1
  override protected var _nextNorma: Norma = new Norma2(starMode)


  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def nextNorma: Norma = _nextNorma


  //SETTERS
  /// Documentation inherited from [[Norma]]
  def nextNorma_(newNorma: Norma2): Unit = {
    _nextNorma = newNorma
  }


  //EQUALS METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Norma1]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Norma1]
      starMode == other.starMode &&
        starsRequired == other.starsRequired &&
        victoriesRequired == other.victoriesRequired
        nextNorma == other.nextNorma
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[Norma1],
      starMode)
  }
}
