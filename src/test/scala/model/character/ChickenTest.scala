package cl.uchile.dcc.citric
package model.character

import model.character.wild.Chicken

class ChickenTest extends munit.FunSuite {
  private val name = "Chicken"
  private val name2 = "Chicken2"
  private val maxHp = 3
  private val hp = 3
  private val attack = -1
  private val defense = -1
  private val evasion = 1
  private val stars = 0
  
  private var chicken: Chicken = _
  private var chicken2: Chicken = _
  
  override def beforeEach(context: BeforeEach): Unit = {
    chicken = new Chicken(name)
    chicken2 = new Chicken(name2)
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
    assertEquals(chicken, new Chicken(name))
    assertNotEquals(chicken, chicken2)
    assert(!chicken.equals(name))
  }

  test("The hash code of a Chicken is consistent with equals") {
    assertEquals(new Chicken(name).##, chicken.##)
    assertEquals(new Chicken(name2).##, chicken2.##)
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
}
