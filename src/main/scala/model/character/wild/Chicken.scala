package cl.uchile.dcc.citric
package model.character.wild

import cl.uchile.dcc.citric.model.character.PlayerCharacter
import cl.uchile.dcc.citric.model.character.Character

import java.util.Objects
import scala.util.Random

class Chicken(name: String, maxHp: Int = 3, stars: Int = 0, randomNumberGenerator: Random)
  extends AbstractWildCharacter(name, maxHp, stars, randomNumberGenerator) with Equals {

  override protected var _hp: Int = 3
  override protected var _attack: Int = -1
  override protected var _defense: Int = -1
  override protected var _evasion: Int = 1

  //EQUALS AND HASH METHODS
  /// Documentation inherited from [[Equals]]
  override def canEqual(that: Any): Boolean = that.isInstanceOf[Chicken]

  /// Documentation inherited from [[Equals]]
  override def equals(that: Any): Boolean = {
    if (canEqual(that)) {
      val other = that.asInstanceOf[Chicken]
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
    Objects.hash(classOf[Chicken],
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      stars)
  }

  /// Documentation inherited from [[Character]]
  def toAttack(other: Character, choice: Boolean): Unit = {
    other.toAttackByChicken(this, choice)
  }

  /// Documentation inherited from [[Character]]
  def toAttackByPlayer(other: PlayerCharacter, choice: Boolean): Unit = {
    if (choice) {
      this.toDefend(other)
    } else {
      this.toEvade(other)
    }
  }

  def toAttackByChicken(other: Chicken, choice: Boolean): Unit = {
    if (choice) {
      this.toDefend(other)
    } else {
      this.toEvade(other)
    }
  }

  def toAttackBySeagull(other: Seagull, choice: Boolean): Unit = {
    if (choice) {
      this.toDefend(other)
    } else {
      this.toEvade(other)
    }
  }

  def toAttackByRoboBall(other: RoboBall, choice: Boolean): Unit = {
    if (choice) {
      this.toDefend(other)
    } else {
      this.toEvade(other)
    }
  }

  override def toDefend(other: Character): Unit = {
    other.toDefendByChicken(this)
  }

  override def toDefendByPlayer(other: PlayerCharacter): Unit = {
    val roll_defense = other.rollDice()
    val roll_attack = this.rollDice()
    val damage = 1.max(roll_attack + this.attack - roll_defense - other.defense)
    other.hp_(other.hp - damage)
    if (other.hp <= 0) {
      other.stars_(other.stars / 2)
      this.stars_(this.stars + other.stars)
    }
  }

  override def toDefendByChicken(other: Chicken): Unit = {
    // Nothing happens, they are alies.
  }

  override def toDefendBySeagull(other: Seagull): Unit = {
    // Nothing happens, they are alies.
  }

  override def toDefendByRoboBall(other: RoboBall): Unit = {
    // Nothing happens, they are alies.
  }

  override def toEvade(other: Character): Unit = {
    other.toEvadeByChicken(this)
  }


  override def toEvadeByPlayer(other: PlayerCharacter): Unit = {
    val roll_evasion = other.rollDice()
    val roll_attack = this.rollDice()
    val damage = roll_attack + this.attack
    if (roll_evasion + other.evasion <= damage) {
      other.hp_(other.hp - damage)
    }
    if (other.hp <= 0) {
      other.stars_(other.stars / 2)
      this.stars_(this.stars + other.stars)
    }
  }

  override def toEvadeByChicken(other: Chicken): Unit = {
    // Nothing happens, they are alies.
  }

  override def toEvadeBySeagull(other: Seagull): Unit = {
    // Nothing happens, they are alies.
  }

  override def toEvadeByRoboBall(other: RoboBall): Unit = {
    // Nothing happens, they are alies.
  }


}
