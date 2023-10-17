package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.norma.Norma1
import scala.util.Random
class Norma1Test extends munit.FunSuite {
  /* Current values of testPlayer. */
  private val starMode1 = true
  private val victorieMode1 = true
  private val maxHp = 10


  /* Current values of testPanel. */
  private val characters1 = ArrayBuffer[Character]()
  private val characters2 = ArrayBuffer[Character]()
  private val nextPanels1 = ArrayBuffer[Panel]()
  private val nextPanels2 = ArrayBuffer[Panel]()

  /* Pre-definition of the characters and panels. */
  private var character1: PlayerCharacter = _
  private var character2: PlayerCharacter = _
  private var panel1: NeutralPanel = _
  private var panel2: NeutralPanel = _
  nextPanels1 += panel1
  nextPanels2 += panel2


  override def beforeEach(context: BeforeEach): Unit = {
    character1 = new PlayerCharacter(
      name1,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      ko,
      randomNumberGenerator)
    character2 = new PlayerCharacter(
      name2,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      ko,
      randomNumberGenerator)
    panel1 = new NeutralPanel(characters1, nextPanels1)
    panel2 = new NeutralPanel(characters2, nextPanels2)
  }


  test("A Norma1 has params") {

  }

  test("The hash code of a Norma1 is consistent with equals") {
    assertEquals(new Norma1(mode).##, norma1.##)
  }
}
