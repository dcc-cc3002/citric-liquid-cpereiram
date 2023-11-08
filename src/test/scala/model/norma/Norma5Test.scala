package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import scala.util.Random

class Norma5Test extends munit.FunSuite {
  /* Current values of testNorma5. */
  //Norma5
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
  private var norma5_1: Norma5 = _
  private var norma5_2: Norma5 = _
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma5_1 = new Norma5(starMode1)
    norma5_2 = new Norma5(victoryMode1)
    player1 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma5_1,
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
      norma5_2,
      stars2,
      victories2,
      randomNumberGenerator
    )
  }

  test("A Norma5 has params") {
    assertEquals(norma5_1.starMode, starMode1)
    assertEquals(norma5_2.starMode, victoryMode1)
    assertNotEquals(norma5_1.starMode, victoryMode1)
    assertNotEquals(norma5_2.starMode, starMode1)
    assertEquals(norma5_1.starsRequired, 200)
    assertEquals(norma5_2.starsRequired, 200)
    assertEquals(norma5_1.victoriesRequired, 14)
    assertEquals(norma5_2.victoriesRequired, 14)
  }

  test("The hash code of a Norma5 is consistent with equals") {
    assertEquals(new Norma5(starMode1).##, norma5_1.##)
    assertEquals(new Norma5(victoryMode1).##, norma5_2.##)
  }

  test("A Norma5 can be equal to another one.") {
    assertEquals(norma5_1, norma5_1)
    assertEquals(norma5_1, new Norma5(starMode1))
    assertNotEquals(norma5_1, norma5_2)
    assert(!norma5_1.equals(player1))
  }

}
