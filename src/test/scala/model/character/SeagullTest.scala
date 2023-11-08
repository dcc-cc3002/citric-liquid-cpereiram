package cl.uchile.dcc.citric
package model.character

import model.character.wild.Seagull

class SeagullTest extends munit.FunSuite {
  private val name = "Seagull"
  private val name2 = "Seagull2"
  private val maxHp = 3
  private val hp = 3
  private val attack = 1
  private val defense = -1
  private val evasion = -1
  private val stars = 0

  private var seagull: Seagull = _
  private var seagull2: Seagull = _

  override def beforeEach(context: BeforeEach): Unit = {
    seagull = new Seagull(name)
    seagull2 = new Seagull(name2)
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
    assertEquals(seagull, new Seagull(name))
    assertNotEquals(seagull, seagull2)
    assert(!seagull.equals(name))
  }

  test("The hash code of a Seagull is consistent with equals") {
    assertEquals(new Seagull(name).##, seagull.##)
    assertEquals(new Seagull(name2).##, seagull2.##)
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
}
