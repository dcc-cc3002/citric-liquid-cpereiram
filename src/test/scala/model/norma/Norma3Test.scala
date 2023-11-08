package cl.uchile.dcc.citric
package model.norma

import model.character.PlayerCharacter

import scala.util.Random

class Norma3Test extends munit.FunSuite {
  /* Current values of testNorma3. */
  //Norma3
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
  private var norma3_1: Norma3 = _
  private var norma3_2: Norma3 = _
  private var player1: PlayerCharacter = _
  private var player2: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma3_1 = new Norma3(starMode1)
    norma3_2 = new Norma3(victoryMode1)
    player1 = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma3_1,
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
      norma3_2,
      stars2,
      victories2,
      randomNumberGenerator
    )
  }

  test("A Norma3 has params") {
    assertEquals(norma3_1.starMode, starMode1)
    assertEquals(norma3_2.starMode, victoryMode1)
    assertNotEquals(norma3_1.starMode, victoryMode1)
    assertNotEquals(norma3_2.starMode, starMode1)
    assertEquals(norma3_1.starsRequired, 70)
    assertEquals(norma3_2.starsRequired, 70)
    assertEquals(norma3_1.victoriesRequired, 6)
    assertEquals(norma3_2.victoriesRequired, 6)
  }

  test("The hash code of a Norma3 is consistent with equals") {
    assertEquals(new Norma3(starMode1).##, norma3_1.##)
    assertEquals(new Norma3(victoryMode1).##, norma3_2.##)
  }

  test("A Norma3 can be equal to another one.") {
    assertEquals(norma3_1, norma3_1)
    assertEquals(norma3_1, new Norma3(starMode1))
    assertNotEquals(norma3_1, norma3_2)
    assert(!norma3_1.equals(player1))
  }

}
