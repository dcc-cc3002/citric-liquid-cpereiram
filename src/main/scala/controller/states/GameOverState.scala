package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the IdleState of the game. It is a GameState.
 * @param context is the GameController of the game.
 */
class GameOverState(context: GameController) extends GameState(context) {
  /**
   * Method that change the game from GameOverState to StartingState.
   */
  override def newGame(): Unit = {
    context.state = new StartingState(context)
  }
}
