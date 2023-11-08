package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

abstract class AbstractNorma(protected val _starMode: Boolean) extends Norma {
  //GETTERS
  /// Documentation inherited from [[Norma]]
  override def starMode: Boolean = _starMode

  /// Documentation inherited from [[Norma]]
  override def starsRequired: Int = _starsRequired

  /// Documentation inherited from [[Norma]]
  override def victoriesRequired: Int = _victoriesRequired

  /// Documentation inherited from [[Norma]]
  override def nextNorma: Norma = _nextNorma

  //SETTERS
  /// Documentation inherited from [[Norma]]
  def nextNorma_(newNorma: Norma): Unit = {
    _nextNorma = newNorma
  }

  //METHODS
  ///Documentation inherited from [[Norma]]
  override def check(character: PlayerCharacter): Boolean = {
    if (starMode) {
      character.stars >= starsRequired
    } else {
      character.victories >= victoriesRequired
    }
  }
}
