package cl.uchile.dcc.citric
package controller.states

/**
 * Trait that represents a state of the game.
 * It has all the methods that can be called in the game.
 */
trait GameState {
  /**
   * Method that starts the game.
   */
  def startGame(): Unit

  /**
   * Method that rolls the dice.
   */
  def rollDice(): Unit

  /**
   * Method that applies the effect of the current panel.
   */
  def applyEffect(): Unit

  /**
   * Method that chooses the panel to move to.
   */
  def choosePanel(): Unit

  /**
   * Method that moves the player to the next panel.
   */
  def nextTurn(): Unit

  /**
   * Method that ends the turn.
   */
  def turnEnded(): Unit

  /**
   * Method that change the game to the GameOverState.
   */
  def endGame(): Unit

  /**
   * Method that change the game to the StatingState.
   */
  def newGame(): Unit

  /**
   * Method that change the game to the Norma Check state.
   */
  def normaCheck(): Unit

  /**
   * Method that begins the battle against other players or a Wild unit.
   */
  def beginBattle(): Unit

  /**
   * Method that ends the battle.
   */
  def endBattle(): Unit

}
