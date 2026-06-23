package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the IdleState of the game. It is a GameState.
 * @param context is the GameController of the game.
 */
class CheckingNormaState(context: GameController) extends GameState(context) {
  /**
   * Method that ends the turn, moving into the IdleState.
   */
  override def turnEnded(): Unit = {
    context.state = new IdleState(context)
  }

  /**
   * Method that change the game to the GameOverState.
   */
  override def endGame(): Unit = {
    context.state = new GameOverState(context)
  }
}
