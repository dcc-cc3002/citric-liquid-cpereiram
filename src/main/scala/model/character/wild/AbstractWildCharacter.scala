package cl.uchile.dcc.citric
package model.character.wild

import model.character.AbstractCharacter

import java.util.Objects

abstract class AbstractWildCharacter(name: String,
                                      maxHp: Int,
                                      stars: Int)
  extends AbstractCharacter(name, maxHp, stars){

  //METHODS
  override def toAttack(): Unit = ???

  override def toDefend(): Unit = ???

  override def toEvade(): Unit = ???
}
