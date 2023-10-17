package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.norma.Norma1
import scala.util.Random
class Norma1Test extends munit.FunSuite {
  /* Current values of testPlayer. */
  private val starMode1 = true
  private val victoryMode1 = false

  /* Pre-definition of the norma. */
  private var norma1_1: Norma1 = _
  private var norma1_2: Norma1 = _

  override def beforeEach(context: BeforeEach): Unit = {
    norma1_1 = new Norma1(starMode1)
    norma1_2 = new Norma1(victoryMode1)
  }

  test("A Norma1 has params") {
    assertEquals(norma1_1.starMode, starMode1)
    assertEquals(norma1_2.starMode, victoryMode1)
    assertEquals(norma1_1.starMode, victoryMode1)
    assertEquals(norma1_2.starMode, starMode1)
  }

  test("The hash code of a Norma1 is consistent with equals") {
    assertEquals(new Norma1(mode).##, norma1.##)
  }
}
