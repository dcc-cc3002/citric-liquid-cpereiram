package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.character.PlayerCharacter
import cl.uchile.dcc.citric.model.norma.Norma1

import scala.util.Random
class Norma1Test extends munit.FunSuite {
  /* Current values of testNorma1. */
  //Norma1
  private val starMode1 = true
  private val victoryMode1 = false
  //PlayerCharacter
  private val name = "testPlayer"
  private val maxHp = 10
  private var hp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val stars1 = 10
  private val stars2 = 0
  private val victories1 = 0
  private val victories2 = 1
  private val randomNumberGenerator = new Random(11)

  /* Pre-definition of the norma and player. */
  private var norma1_1: Norma1 = _
  private var norma1_2: Norma1 = _
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma1_1 = new Norma1(starMode1)
    norma1_2 = new Norma1(victoryMode1)
    player1 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma1_1,
      stars1,
      victories1,
      randomNumberGenerator
    )
    player2 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma1_2,
      stars2,
      victories2,
      randomNumberGenerator
    )
  }

  test("A Norma1 has params") {
    assertEquals(norma1_1.starMode, starMode1)
    assertEquals(norma1_2.starMode, victoryMode1)
    assertNotEquals(norma1_1.starMode, victoryMode1)
    assertNotEquals(norma1_2.starMode, starMode1)
    assertEquals(norma1_1.starsRequired, 10)
    assertEquals(norma1_2.starsRequired, 10)
    assertEquals(norma1_1.victoriesRequired, 1)
    assertEquals(norma1_2.victoriesRequired, 1)
  }

  test("The hash code of a Norma1 is consistent with equals") {
    assertEquals(new Norma1(starMode1).##, norma1_1.##)
    assertEquals(new Norma1(victoryMode1).##, norma1_2.##)
  }

  test("A Norma1 can be equal to another one.") {
    assertEquals(norma1_1, norma1_1)
    assertEquals(norma1_1, new Norma1(starMode1))
    assertNotEquals(norma1_1, norma1_2)
    assert(!norma1_1.equals(player1))
  }
}
