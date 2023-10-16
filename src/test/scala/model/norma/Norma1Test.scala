package cl.uchile.dcc.citric
package model.norma

import cl.uchile.dcc.citric.model.norma.Norma1
import scala.util.Random
class Norma1Test extends munit.FunSuite {
  test("A Norma1 has params") {

  }

  test("The hash code of a Norma1 is consistent with equals") {
    assertEquals(new BonusPanel(characters1, nextPanels1).##, panel1.##)
  }
}
