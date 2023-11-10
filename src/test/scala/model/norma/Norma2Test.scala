package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import scala.util.Random

class Norma2Test extends munit.FunSuite {
  /* Current values of testNorma2. */
  //Norma2
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
  private val norma3_1 = new Norma3(starMode1)
  private val norma3_2 = new Norma3(victoryMode1)

  /* Pre-definition of the norma and player. */
  private var norma2_1: Norma2 = _
  private var norma2_2: Norma2 = _
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma2_1 = new Norma2(starMode1)
    norma2_2 = new Norma2(victoryMode1)
    player1 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma2_1,
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
      norma2_2,
      stars2,
      victories2,
      randomNumberGenerator
    )
  }

  test("A Norma2 has params") {
    assertEquals(norma2_1.starMode, starMode1)
    assertEquals(norma2_2.starMode, victoryMode1)
    assertNotEquals(norma2_1.starMode, victoryMode1)
    assertNotEquals(norma2_2.starMode, starMode1)
    assertEquals(norma2_1.starsRequired, 30)
    assertEquals(norma2_2.starsRequired, 30)
    assertEquals(norma2_1.victoriesRequired, 3)
    assertEquals(norma2_2.victoriesRequired, 3)
    assertEquals(norma2_1.nextNorma, norma3_1)
    assertEquals(norma2_2.nextNorma, norma3_2)
  }

  test("The hash code of a Norma2 is consistent with equals") {
    assertEquals(new Norma2(starMode1).##, norma2_1.##)
    assertEquals(new Norma2(victoryMode1).##, norma2_2.##)
  }

  test("A Norma2 can be equal to another one.") {
    assertEquals(norma2_1, norma2_1)
    assertEquals(norma2_1, new Norma2(starMode1))
    assertNotEquals(norma2_1, norma2_2)
    assert(!norma2_1.equals(player1))
  }

  test("A nextNorma can be changed.") {
    assertEquals(norma2_1.nextNorma, norma3_1)
    assertEquals(norma2_2.nextNorma, norma3_2)
    norma2_1.nextNorma_(norma3_2)
    norma2_2.nextNorma_(norma3_1)
    assertEquals(norma2_1.nextNorma, norma3_2)
    assertEquals(norma2_2.nextNorma, norma3_1)
  }
}
