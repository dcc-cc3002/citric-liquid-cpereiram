package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import scala.util.Random

class Norma4Test extends munit.FunSuite {
  /* Current values of testNorma4. */
  //Norma4
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
  private val norma5_1 = new Norma5(starMode1)
  private val norma5_2 = new Norma5(victoryMode1)

  /* Pre-definition of the norma and player. */
  private var norma4_1: Norma4 = _
  private var norma4_2: Norma4 = _
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma4_1 = new Norma4(starMode1)
    norma4_2 = new Norma4(victoryMode1)
    player1 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma4_1,
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
      norma4_2,
      stars2,
      victories2,
      randomNumberGenerator
    )
  }

  test("A Norma4 has params") {
    assertEquals(norma4_1.starMode, starMode1)
    assertEquals(norma4_2.starMode, victoryMode1)
    assertNotEquals(norma4_1.starMode, victoryMode1)
    assertNotEquals(norma4_2.starMode, starMode1)
    assertEquals(norma4_1.starsRequired, 120)
    assertEquals(norma4_2.starsRequired, 120)
    assertEquals(norma4_1.victoriesRequired, 10)
    assertEquals(norma4_2.victoriesRequired, 10)
  }

  test("The hash code of a Norma4 is consistent with equals") {
    assertEquals(new Norma4(starMode1).##, norma4_1.##)
    assertEquals(new Norma4(victoryMode1).##, norma4_2.##)
  }

  test("A Norma4 can be equal to another one.") {
    assertEquals(norma4_1, norma4_1)
    assertEquals(norma4_1, new Norma4(starMode1))
    assertNotEquals(norma4_1, norma4_2)
    assert(!norma4_1.equals(player1))
  }

  test("A nextNorma can be changed.") {
    norma4_1.nextNorma_(norma5_2)
    assertEquals(norma4_1.nextNorma, norma5_2)
    norma4_2.nextNorma_(norma5_1)
    assertEquals(norma4_2.nextNorma, norma5_1)
  }

}
