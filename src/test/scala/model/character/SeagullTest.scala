package cl.uchile.dcc.citric
package model.character

import model.character.wild.{Chicken, RoboBall, Seagull}

import cl.uchile.dcc.citric.model.norma.Norma1

import scala.util.Random

class SeagullTest extends munit.FunSuite {
  private val name = "Seagull"
  private val name2 = "Seagull2"
  private val maxHp = 3
  private val hp = 3
  private val attack = 1
  private val defense = -1
  private val evasion = -1
  private val norma = new Norma1(true)
  private val stars = 0
  private val victories = 0
  private val randomNumberGenerator = new Random(11)


  private var seagull: Seagull = _
  private var seagull2: Seagull = _
  private var roboball: RoboBall = _
  private var chicken: Chicken = _
  private var player: PlayerCharacter = _

  override def beforeEach(context: BeforeEach): Unit = {
    seagull = new Seagull(name, randomNumberGenerator = randomNumberGenerator)
    seagull2 = new Seagull(name2, randomNumberGenerator = randomNumberGenerator)
    roboball = new RoboBall("1", randomNumberGenerator = randomNumberGenerator)
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

  test("A Seagull should have correctly set their attributes") {
    assertEquals(seagull.name, name)
    assertEquals(seagull.maxHp, maxHp)
    assertEquals(seagull.hp, hp)
    assertEquals(seagull.attack, attack)
    assertEquals(seagull.defense, defense)
    assertEquals(seagull.evasion, evasion)
    assertEquals(seagull.stars, stars)
  }

  test("A Seagull could be equal to another Seagull") {
    assertEquals(seagull, seagull)
    assertEquals(seagull, new Seagull(name, randomNumberGenerator = randomNumberGenerator))
    assertNotEquals(seagull, seagull2)
    assert(!seagull.equals(name))
  }

  test("The hash code of a Seagull is consistent with equals") {
    assertEquals(new Seagull(name, randomNumberGenerator = randomNumberGenerator).##, seagull.##)
    assertEquals(new Seagull(name2, randomNumberGenerator = randomNumberGenerator).##, seagull2.##)
  }

  test("A Seagull stats can be set") {
    seagull.hp_(10)
    assertEquals(seagull.hp, 10)
    seagull.attack_(10)
    assertEquals(seagull.attack, 10)
    seagull.defense_(10)
    assertEquals(seagull.defense, 10)
    seagull.evasion_(10)
    assertEquals(seagull.evasion, 10)
  }

  test("A Seagull can be KO") {
    seagull.hp_(0)
    assert(seagull.isKo())
    seagull.hp_(1)
    assert(!seagull.isKo())
  }

  test("A Seagull can attack a WildCharacter and nothing happens.") {
    seagull.toAttack(seagull2, true)
    assertEquals(seagull2.hp, 3)
    seagull.toAttack(seagull2, false)
    assertEquals(seagull2.hp, 3)
    seagull.toAttack(roboball, true)
    assertEquals(roboball.hp, 3)
    seagull.toAttack(roboball, false)
    assertEquals(roboball.hp, 3)
    seagull.toAttack(chicken, true)
    assertEquals(chicken.hp, 3)
    seagull.toAttack(chicken, false)
    assertEquals(chicken.hp, 3)
  }

  test("A Seagull can attack a PlayerCharacter.") {
    //if player defends, he will die.
    seagull.toAttack(player, true)
    //assert(player.isKo())
    //if player evades, he could die (random).
    seagull.toAttack(player, false)
    assert(player.hp <= 1)
  }
}
