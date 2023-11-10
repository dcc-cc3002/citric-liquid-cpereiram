package cl.uchile.dcc.citric
package model.character.wild

import model.character.AbstractCharacter

import java.util.Objects
import scala.util.Random

abstract class AbstractWildCharacter(name: String,
                                      maxHp: Int,
                                      stars: Int,
                                      randomNumberGenerator: Random)
  extends AbstractCharacter(name, maxHp, stars, randomNumberGenerator){
}