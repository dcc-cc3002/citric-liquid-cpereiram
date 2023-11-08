package cl.uchile.dcc.citric
package model.character

import model.character.wild.RoboBall

class RoboBallTest extends munit.FunSuite {
  private val name = "RoboBall"
  private val name2 = "RoboBall2"
  private val maxHp = 3
  private val hp = 3
  private val attack = -1
  private val defense = 1
  private val evasion = -1
  private val stars = 0

  private var roboball: RoboBall = _
  private var roboball2: RoboBall = _

  override def beforeEach(context: BeforeEach): Unit = {
    roboball = new RoboBall(name)
    roboball2 = new RoboBall(name2)
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
    assertEquals(roboball, new RoboBall(name))
    assertNotEquals(roboball, roboball2)
    assert(!roboball.equals(name))
  }

  test("The hash code of a RoboBall is consistent with equals") {
    assertEquals(new RoboBall(name).##, roboball.##)
    assertEquals(new RoboBall(name2).##, roboball2.##)
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
}
