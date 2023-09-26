package cl.uchile.dcc.citric
package model.board.panel

import model.character.PlayerCharacter

import scala.util.Random

class NeutralPanelTest extends munit.FunSuite {
  /* Current values of testPlayer. */
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val randomNumberGenerator = new Random(11)

  /* Pre-definition of the player. */
  private var character: PlayerCharacter = _
  private var panel: NeutralPanel = _

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      randomNumberGenerator
    )
  }

  test("Un panel.") {

  }

  test("The hash code of a FireBakemon is consistent with equals") {
    //assertEquals(new FireBakemon(name, hp).##, fireBakemon.##)
  }

  test("A player can be in the panel.") {

  }

  test("A player can get into the panel.") {

  }

  test("A player can leave the panel.") {

  }

  test("A player can be in the panel.") {

  }

  test("A player can be in the panel.") {

  }
}
