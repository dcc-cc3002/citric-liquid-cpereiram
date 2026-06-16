package cl.uchile.dcc.citric
package model.character

import cl.uchile.dcc.citric.model.norma.Norma
import java.util.Objects
import scala.util.Random

/** An abstract class representing a Character.
 *
 * Every Character are represented by:
 *
 * @param name The name of the player. This is an identifier and should be unique.
 * @param maxHp The maximum health points a player can have. It represents the player's endurance.
 * @param stars The amount of stars a player has. Begins with 0.
 *
 * @constructor Create a new Character.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.3
 * @since 1.0
 */
abstract class AbstractCharacter(protected val _name: String,
                                 protected val _maxHp: Int,
                                 protected var _stars: Int = 0,
                                 protected val randomNumberGenerator: Random = new Random())
  extends Character {

  protected var _hp: Int
  protected var _attack: Int
  protected var _defense: Int
  protected var _evasion: Int

  //GETTERS
  /// Documentation inherited from [[Character]]
  override def name: String = _name

  /// Documentation inherited from [[Character]]
  override def maxHp: Int = _maxHp

  /// Documentation inherited from [[Character]]
  override def stars: Int = _stars

  /// Documentation inherited from [[Character]]
  override def hp: Int = _hp

  /// Documentation inherited from [[Character]]
  override def attack: Int = _attack

  /// Documentation inherited from [[Character]]
  override def defense: Int = _defense

  /// Documentation inherited from [[Character]]
  override def evasion: Int = _evasion


  //SETTERS
  /// Documentation inherited from [[Character]]
  override def stars_(newStars: Int): Unit = {
    _stars = newStars
  }

  /// Documentation inherited from [[Character]]
  override def hp_(newHp: Int): Unit = {
    _hp = newHp
  }

  /// Documentation inherited from [[Character]]
  override def attack_(newAttack: Int): Unit = {
    _attack = newAttack
  }

  /// Documentation inherited from [[Character]]
  override def defense_(newDefense: Int): Unit = {
    _defense = newDefense
  }

  /// Documentation inherited from [[Character]]
  override def evasion_(newEvasion: Int): Unit = {
    _evasion = newEvasion
  }


  //METHODS
  /// Documentation inherited from [[Character]]
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
  /// Documentation inherited from [[Character]]
  override def isKo(): Boolean = {
    _hp == 0
  }
}