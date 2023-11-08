package cl.uchile.dcc.citric
package model.character.wild

import java.util.Objects

class RoboBall(name: String,
               maxHp: Int = 3,
               stars: Int = 0)
  extends AbstractWildCharacter(name,
    maxHp,
    stars) with Equals {

  override protected var _hp: Int = 3
  override protected var _attack: Int = -1
  override protected var _defense: Int = 1
  override protected var _evasion: Int = -1

  //EQUALS AND HASH METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[RoboBall]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[RoboBall]
      name == other.name &&
        maxHp == other.maxHp &&
        hp == other.hp &&
        attack == other.attack &&
        defense == other.defense &&
        evasion == other.evasion &&
        stars == other.stars
    } else {
      false
    }
  }

  /// Documentation inherited from [[Any]]
  override def hashCode: Int = {
    Objects.hash(classOf[RoboBall],
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      stars)
  }
}
