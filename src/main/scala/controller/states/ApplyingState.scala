package cl.uchile.dcc.citric
package controller.states

class ApplyingState extends GameState {
  /**
   * Method that starts the game.
   */
  override def startGame(): Unit = ???

  /**
   * Method that rolls the dice.
   */
  override def rollDice(): Unit = ???

  /**
   * Method that applies the effect of the current panel.
   */
  override def applyEffect(): Unit = ???

  /**
   * Method that chooses the panel to move to.
   */
  override def choosePanel(): Unit = ???

  /**
   * Method that moves the player to the next panel.
   */
  override def nextTurn(): Unit = ???

  /**
   * Method that ends the turn.
   */
  override def turnEnded(): Unit = ???

  /**
   * Method that change the game to the GameOverState.
   */
  override def endGame(): Unit = ???

  /**
   * Method that change the game to the StatingState.
   */
  override def newGame(): Unit = ???

  /**
   * Method that change the game to the Norma Check state.
   */
  override def normaCheck(): Unit = ???

  /**
   * Method that begins the battle against other players or a Wild unit.
   */
  override def beginBattle(): Unit = ???

  /**
   * Method that ends the battle.
   */
  override def endBattle(): Unit = ???
}
