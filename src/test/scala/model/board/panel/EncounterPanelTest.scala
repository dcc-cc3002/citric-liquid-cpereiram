package cl.uchile.dcc.citric
package model.board.panel

import model.character.PlayerCharacter
import model.character.Character

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class EncounterPanelTest extends munit.FunSuite {
  /* Current values of testPlayer. */
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val hp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val ko = false
  private val randomNumberGenerator = new Random(11)

  /* Current values of testPanel. */
  private val characters1 = ArrayBuffer[Character]()
  private val characters2 = ArrayBuffer[Character]()
  private val nextPanels1 = ArrayBuffer[Panel]()
  private val nextPanels2 = ArrayBuffer[Panel]()

  /* Pre-definition of the characters and panels. */
  private var character1: PlayerCharacter = _
  private var character2: PlayerCharacter = _
  private var panel1: EncounterPanel = _
  private var panel2: EncounterPanel = _
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
    panel1 = new EncounterPanel(characters1, nextPanels1)
    panel2 = new EncounterPanel(characters2, nextPanels2)
  }

  test("A NeutralPanel has params") {
    assertEquals(panel1.characters, characters1)
    assertEquals(panel1.nextPanels, nextPanels1)
    assertEquals(panel2.characters, characters2)
    assertEquals(panel2.nextPanels, nextPanels2)
  }

  test("A panel can be equal to another one.") {
    assertEquals(panel1, panel1)
    assertEquals(panel1, new EncounterPanel(characters1, nextPanels1))
    panel1.addCharacter(character1)
    assertNotEquals(panel1, panel2)
    assert(!panel1.equals(character1))
  }

  test("The hash code of a NeutralPanel is consistent with equals") {
    assertEquals(new EncounterPanel(characters1, nextPanels1).##, panel1.##)
  }
}
