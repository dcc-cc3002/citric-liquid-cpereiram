package cl.uchile.dcc.citric
package model.character

import model.character.wild.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.norma.Norma1

import scala.util.Random

class RoboBallTest extends munit.FunSuite {
  private val name = "RoboBall"
  private val name2 = "RoboBall2"
  private val maxHp = 3
  private val hp = 3
  private val attack = -1
  private val defense = 1
  private val evasion = -1
  private val norma = new Norma1(true)
  private val stars = 0
  private val victories = 0
  private val randomNumberGenerator = new Random(11)

  private var roboball: RoboBall = _
  private var roboball2: RoboBall = _
  private var seagull: Seagull = _
  private var chicken: Chicken = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    roboball = new RoboBall(name, randomNumberGenerator = randomNumberGenerator)
    roboball2 = new RoboBall(name2, randomNumberGenerator = randomNumberGenerator)
    seagull = new Seagull("1", randomNumberGenerator = randomNumberGenerator)
    chicken = new Chicken("2", randomNumberGenerator = randomNumberGenerator)
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

  test("A RoboBall should have correctly set their attributes") {
    assertEquals(roboball.name, name)
    assertEquals(roboball.maxHp, maxHp)
    assertEquals(roboball.hp, hp)
    assertEquals(roboball.attack, attack)
    assertEquals(roboball.defense, defense)
    assertEquals(roboball.evasion, evasion)
    assertEquals(roboball.stars, stars)
  }

  test("A RoboBall could be equal to another RoboBall") {
    assertEquals(roboball, roboball)
    assertEquals(roboball, new RoboBall(name, randomNumberGenerator = randomNumberGenerator))
    assertNotEquals(roboball, roboball2)
    assert(!roboball.equals(name))
  }

  test("The hash code of a RoboBall is consistent with equals") {
    assertEquals(new RoboBall(name, randomNumberGenerator = randomNumberGenerator).##, roboball.##)
    assertEquals(new RoboBall(name2, randomNumberGenerator = randomNumberGenerator).##, roboball2.##)
  }

  test("A RoboBall stats can be set") {
    roboball.hp_(10)
    assertEquals(roboball.hp, 10)
    roboball.attack_(10)
    assertEquals(roboball.attack, 10)
    roboball.defense_(10)
    assertEquals(roboball.defense, 10)
    roboball.evasion_(10)
    assertEquals(roboball.evasion, 10)
  }

  test("A RoboBall can be KO") {
    roboball.hp_(0)
    assert(roboball.isKo())
    roboball.hp_(1)
    assert(!roboball.isKo())
  }

  test("A RoboBall can attack a WildCharacter and nothing happens."){
    roboball.toAttack(roboball2, true)
    assertEquals(roboball2.hp, 3)
    roboball.toAttack(roboball2, false)
    assertEquals(roboball2.hp, 3)
    roboball.toAttack(seagull, true)
    assertEquals(seagull.hp, 3)
    roboball.toAttack(seagull, false)
    assertEquals(seagull.hp, 3)
    roboball.toAttack(chicken, true)
    assertEquals(chicken.hp, 3)
    roboball.toAttack(chicken, false)
    assertEquals(chicken.hp, 3)
  }

  test("A RoboBall can attack a PlayerCharacter."){
    //if player defends, he will die.
    roboball.toAttack(player, true)
    assert(player.isKo())
    //if player evades, he could die (random).
    roboball.toAttack(player, false)
    assert(player.hp <= 1)
  }
}
