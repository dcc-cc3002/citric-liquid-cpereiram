package cl.uchile.dcc.citric
package citric

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

  test("A player on the neutral panel can't do nothing.") {

  }

}
