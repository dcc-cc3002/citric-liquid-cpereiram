package cl.uchile.dcc.citric
package model.character

import cl.uchile.dcc.citric.model.norma.Norma1

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  /*
  REMEMBER: It is a good practice to use constants for the values that are used in multiple
  tests, so you can change them in a single place.
  This will make your tests more readable, easier to maintain, and less error-prone.
  */
  private val name = "testPlayer"
  private val name2 = "testPlayer2"
  private val maxHp = 10
  private val hp = 5
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val norma = new Norma1(true)
  private val stars = 0
  private val victories = 0
  private val randomNumberGenerator = new Random(11)
  /* Add any other constants you need here... */

  /*
  This is the object under test.
  We initialize it in the beforeEach method so we can reuse it in all the tests.
  This is a good practice because it will reset the object before each test, so you don't have
  to worry about the state of the object between tests.
  */
  private var character: PlayerCharacter = _  // <- x = _ is the same as x = null
  private var character2: PlayerCharacter = _
  /* Add any other variables you need here... */

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      hp,
      attack,
      defense,
      evasion,
      norma,
      stars,
      victories,
      randomNumberGenerator)
    character2 = new PlayerCharacter(
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
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHp, maxHp)
    assertEquals(character.hp, hp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
    assertEquals(character.norma, norma)
    assertEquals(character.stars, stars)
    assertEquals(character.victories, victories)
  }

  test("A character should be able to roll a dice") {
    for (_ <- 1 to 10) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
    }
  }

  test("A PlayerCharacter could be equal to another with the same attributes values.") {
    assertEquals(new PlayerCharacter(name, maxHp, hp, attack, defense, evasion, norma, stars, victories, new Random(11)), character)
    assertEquals(character, character)
    assertNotEquals(character, character2)
    assert(!character.equals(name))
  }

  test("A PlayerCharacter stats can be set") {
    character.hp_(10)
    assertEquals(character.hp, 10)
    character.attack_(10)
    assertEquals(character.attack, 10)
    character.defense_(10)
    assertEquals(character.defense, 10)
    character.evasion_(10)
    assertEquals(character.evasion, 10)
    character.norma_(new Norma1(false))
    assertEquals(character.norma, new Norma1(false))
    character.stars_(10)
    assertEquals(character.stars, 10)
    character.victories_(10)
    assertEquals(character.victories, 10)
  }

  test("A Character can be KO") {
    character.hp_(0)
    assert(character.isKo())
    character.hp_(20)
    assert(!character.isKo())
  }

  test("A Player can do damage to another Character") {
    character.doDamage(character2, 1)
    assertEquals(character2.hp, 4)
    character.doDamage(character2, 4)
    assertEquals(character2.hp, 0)
    character.doDamage(character2, 1)
    //Should be an exception
    assertEquals(character2.hp, 0)
  }
}
