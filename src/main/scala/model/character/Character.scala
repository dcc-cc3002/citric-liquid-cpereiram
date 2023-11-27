package cl.uchile.dcc.citric
package model.character

import cl.uchile.dcc.citric.model.character.wild.{Chicken, RoboBall, Seagull}
import cl.uchile.dcc.citric.model.norma.Norma

/** Represent a Character in the game, who should be a player or a Wild Unit, .
 *
 * A character is represented with a name, a maximum amount of HP, a current amount
 * of HP, numbers that represents its attack, defense, evasion and a variable state
 * if a character is knockout.
 *
 * A character can:
 * - Attack other Characters.
 * - Be attacked by another Characters.
 * - Be knocked out by a Character.
 *
 * @constructor Create a new Character.
 * @author [[https://github.com/zelcris Cristóbal Pereira M.]]
 * @version 1.5
 * @since 1.0
 */
trait Character {
  //FIELDS
  /** Represents the name of the character. */
  protected val _name: String

  /** Max hit points that a Character will have. */
  protected val _maxHp: Int

  /** Current stars of the Character. */
  protected var _stars: Int

  /** Current hit point of a character.*/
  protected var _hp: Int

  /** Attack stat of a Character. */
  protected var _attack: Int

  /** Defense stat of a Character. */
  protected var _defense: Int

  /** Evasion stat of a Character. */
  protected var _evasion: Int


  //GETTERS
  /** Returns the name of the character. */
  def name: String

  /** Returns the maxHp of the character. */
  def maxHp: Int

  /** Returns the current amount of stars of the character. */
  def stars: Int

  /** Returns the current HP of the character. */
  def hp: Int

  /** Returns the current attack stat of the character. */
  def attack: Int

  /** Returns the current defense stat of the character. */
  def defense: Int

  /** Returns the current evasion stat of the character. */
  def evasion: Int


  //SETTERS
  /** Set the current amount of stars of the character. */
  def stars_(newStars: Int): Unit

  /** Set the current HP of the character. */
  def hp_(newHp: Int): Unit

  /** Set the current attack stat of the character. */
  def attack_(newAttack: Int): Unit

  /** Set the current defense stat of the character. */
  def defense_(newDefense: Int): Unit

  /** Set the current evasion stat of the character. */
  def evasion_(newEvasion: Int): Unit


  //METHODS

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice: Int

  /** Method that returns the state of the character. */
  def isKo: Boolean

  /** A character can attack another one.
   *
   * @param other Character that will be attacked.
   * @param choice Boolean that represents if the attacked character will defend or evade.
   *               True if the character will defend, false if the character will evade.
   * */
  def toAttack(other: Character, choice: Boolean): Unit

  /** A character can get attack by another one.
   *
   * @param other Character that will attack.
   * @param choice Boolean that represents if the attacked character will defend or evade.
   *               True if the character will defend, false if the character will evade. */
  def toAttackByPlayer(other: PlayerCharacter, choice: Boolean): Unit

  /** A character can get attack by a Chicken.
   *
   * @param other  Character that will attack.
   * @param choice Boolean that represents if the attacked character will defend or evade.
   *               True if the character will defend, false if the character will evade. */
  def toAttackByChicken(other: Chicken, choice: Boolean): Unit

  /** A character can get attack by a Seagull
   *
   * @param other  Character that will attack.
   * @param choice Boolean that represents if the attacked character will defend or evade.
   *               True if the character will defend, false if the character will evade. */
  def toAttackBySeagull(other: Seagull, choice: Boolean): Unit

  /** A character can get attack by a RoboBall
   *
   * @param other  Character that will attack.
   * @param choice Boolean that represents if the attacked character will defend or evade.
   *               True if the character will defend, false if the character will evade. */
  def toAttackByRoboBall(other: RoboBall, choice: Boolean): Unit


  /** A character can defend against another one. */
  def toDefend(other: Character): Unit

  /** A PlayerCharacter can defend against a Character. */
  def toDefendByPlayer(other: PlayerCharacter): Unit

  /** A Chicken can defend against a Character. */
  def toDefendByChicken(other: Chicken): Unit

  /** A Seagull can defend against a Character. */
  def toDefendBySeagull(other: Seagull): Unit

  /** A RoboBall can defend against a Character. */
  def toDefendByRoboBall(other: RoboBall): Unit


  /** A character can evade an attack. */
  def toEvade(other: Character): Unit

  /** A PlayerCharacter can evade an attack from a Character. */
  def toEvadeByPlayer(other: PlayerCharacter): Unit

  /** A Chicken can evade an attack from a Character. */
  def toEvadeByChicken(other: Chicken): Unit

  /** A Seagull can evade an attack from a Character. */
  def toEvadeBySeagull(other: Seagull): Unit

  /** A RoboBall can evade an attack from a Character. */
  def toEvadeByRoboBall(other: RoboBall): Unit

}
