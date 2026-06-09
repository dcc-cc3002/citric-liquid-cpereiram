package cl.uchile.dcc.citric
package model.character

import model.character.wild.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.norma.Norma1

import scala.util.Random

class ChickenTest extends munit.FunSuite {
  private val name = "Chicken"
  private val name2 = "Chicken2"
  private val maxHp = 3
  private val hp = 3
  private val attack = -1
  private val defense = -1
  private val evasion = 1
  private val norma = new Norma1(true)
  private val stars = 0
  private val victories = 0
  private val randomNumberGenerator = new Random(11)


  private var chicken: Chicken = _
  private var chicken2: Chicken = _
  private var roboball: RoboBall = _
  private var seagull: Seagull = _
  private var player: PlayerCharacter = _
  
  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken(name, randomNumberGenerator = randomNumberGenerator)
    chicken2 = new Chicken(name2, randomNumberGenerator = randomNumberGenerator)
    roboball = new RoboBall("1", randomNumberGenerator = randomNumberGenerator)
    seagull = new Seagull("2", randomNumberGenerator = randomNumberGenerator)
    player = new PlayerCharacter("Player",
      maxHp,
      1,
      attack,
      defense,
      evasion,
      norma,
      stars,
      victories,
      randomNumberGenerator)
  }
  
  test("A Chicken should have correctly set their attributes") {
    assertEquals(chicken.name, name)
    assertEquals(chicken.maxHp, maxHp)
    assertEquals(chicken.hp, hp)
    assertEquals(chicken.attack, attack)
    assertEquals(chicken.defense, defense)
    assertEquals(chicken.evasion, evasion)
    assertEquals(chicken.stars, stars)
  }

  test("A Chicken could be equal to another Chicken") {
    assertEquals(chicken, chicken)
    assertEquals(chicken, new Chicken(name, randomNumberGenerator = randomNumberGenerator))
    assertNotEquals(chicken, chicken2)
    assert(!chicken.equals(name))
  }

  test("The hash code of a Chicken is consistent with equals") {
    assertEquals(new Chicken(name, randomNumberGenerator = randomNumberGenerator).##, chicken.##)
    assertEquals(new Chicken(name2, randomNumberGenerator = randomNumberGenerator).##, chicken2.##)
  }

  test("A Chicken stats can be set") {
    chicken.hp_(10)
    assertEquals(chicken.hp, 10)
    chicken.attack_(10)
    assertEquals(chicken.attack, 10)
    chicken.defense_(10)
    assertEquals(chicken.defense, 10)
    chicken.evasion_(10)
    assertEquals(chicken.evasion, 10)
  }

  test("A Chicken can be KO") {
    chicken.hp_(0)
    assert(chicken.isKo())
    chicken.hp_(1)
    assert(!chicken.isKo())
  }

  test("A Seagull can attack a WildCharacter and nothing happens.") {
    chicken.toAttack(chicken2, true)
    assertEquals(chicken2.hp, 3)
    chicken.toAttack(chicken2, false)
    assertEquals(chicken2.hp, 3)
    chicken.toAttack(roboball, true)
    assertEquals(roboball.hp, 3)
    chicken.toAttack(roboball, false)
    assertEquals(roboball.hp, 3)
    chicken.toAttack(seagull, true)
    assertEquals(seagull.hp, 3)
    chicken.toAttack(seagull, false)
    assertEquals(seagull.hp, 3)
  }

  test("A Chicken can attack a PlayerCharacter.") {
    //if player defends, he will die.
    chicken.toAttack(player, true)
    //assert(player.isKo())
    //if player evades, he could die (random).
    chicken.toAttack(player, false)
    assert(player.hp <= 1)
  }
}
