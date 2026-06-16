package cl.uchile.dcc.citric
package model.board.panel

import cl.uchile.dcc.citric.model.character.PlayerCharacter
import cl.uchile.dcc.citric.model.character.Character
import cl.uchile.dcc.citric.model.norma.{Norma, Norma1, Norma2}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class HomePanelTest extends munit.FunSuite {
  /* Current values of testPlayer. */
  private val name1 = "testPlayer1"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val hp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val norma: Norma1 = new Norma1(true)
  private val norma2: Norma = new Norma2(true)
  private val stars = 0
  private val victories = 0
  private val randomNumberGenerator = new Random(11)

  /* Definition of the characters */
  private val character1: PlayerCharacter = new PlayerCharacter(
    name1,
    maxHp,
    hp,
    attack,
    defense,
    evasion,
    norma,
    stars,
    victories,
    randomNumberGenerator)
  private val character2: PlayerCharacter = new PlayerCharacter(
    name2,
    maxHp,
    hp,
    attack,
    defense,
    evasion,
    norma,
    stars,
    victories,
    randomNumberGenerator)
  /* Pre-definition of the panel and character arrays. */
  private var characters1: ArrayBuffer[Character] = _
  private var characters2: ArrayBuffer[Character] = _
  private var nextPanels1: ArrayBuffer[Panel] = _
  private var nextPanels2: ArrayBuffer[Panel] = _
  private var panel1: HomePanel = _
  private var panel2: HomePanel = _


  override def beforeEach(context: BeforeEach): Unit = {
    characters1 = ArrayBuffer[Character]()
    characters2 = ArrayBuffer[Character]()
    nextPanels1 = ArrayBuffer[Panel]()
    nextPanels2 = ArrayBuffer[Panel]()
    panel1 = new HomePanel(characters1, nextPanels1, character1)
    panel2 = new HomePanel(characters2, nextPanels2, character2)
  }

  test("A HomePanel has params") {
    assertEquals(panel1.characters, characters1)
    assertEquals(panel1.nextPanels, nextPanels1)
    assertEquals(panel2.characters, characters2)
    assertEquals(panel2.nextPanels, nextPanels2)
    assertEquals(panel1.owner, character1)
    assertEquals(panel2.owner, character2)
  }

  test("A panel can be equal to another one.") {
    assertEquals(panel1, panel1)
    assertEquals(panel1, new HomePanel(characters1, nextPanels1, character1))
    panel1.addCharacter(character1)
    assertNotEquals(panel1, panel2)
    assert(!panel1.equals(character1))
    panel1.removeCharacter(character1)
  }

  test("The hash code of a HomePanel is consistent with equals") {
    assertEquals(new HomePanel(characters1, nextPanels1, character1).##, panel1.##)
  }

  test("A HomePanel can add and remove a character") {
    panel1.addCharacter(character1)
    panel1.addCharacter(character2)
    assertEquals(panel1.characters, ArrayBuffer[Character](character1, character2))
    panel1.removeCharacter(character1)
    assertEquals(panel1.characters, ArrayBuffer[Character](character2))
    panel1.removeCharacter(character2)
    assertEquals(panel1.characters, ArrayBuffer[Character]())
  }

  test("A HomePanel can't remove a character that is not in it") {
    panel1.addCharacter(character1)
    panel1.removeCharacter(character2)
    assertEquals(panel1.characters, ArrayBuffer[Character](character1))
  }

  test("A HomePanel can add a nextPanel") {
    panel1.addNextPanel(panel2)
    assertEquals(panel1.nextPanels, ArrayBuffer[Panel](panel2))
    panel1.addNextPanel(panel1)
    assertEquals(panel1.nextPanels, ArrayBuffer[Panel](panel2, panel1))
  }

  test("A HomePanel can remove a nextPanel") {
    panel1.addNextPanel(panel2)
    panel1.addNextPanel(panel1)
    //panel1 = [panel2, panel1]
    assertEquals(panel1.nextPanels, ArrayBuffer[Panel](panel2, panel1))
    panel1.removeNextPanel(panel1)
    //panel1 = [panel2]
    assertEquals(panel1.nextPanels, ArrayBuffer[Panel](panel2))
    panel1.removeNextPanel(panel2)
    //panel1 = []
    assertEquals(panel1.nextPanels, ArrayBuffer[Panel]())
  }

  test("A HomePanel will apply its effect, NormaCheck, to a character") {
    assertEquals(character1.hp, hp)
    //hp = 5
    //stars = 0
    panel1.apply(character1)
    //should heal up
    assertEquals(character1.hp, maxHp)
    //hp = 10
    //stars = 0 != 10 then everything is the same
    assertEquals(character1.norma, norma)
    assertEquals(character1.stars, stars)
    assertEquals(character1.victories, victories)
    character1.stars_(10)
    //stars = 10 NormaCheck should be true
    panel1.apply(character1)
    assertEquals(character1.stars, 10)
    //the norma should change up.
    assertNotEquals(character1.norma, norma2)
  }
}
