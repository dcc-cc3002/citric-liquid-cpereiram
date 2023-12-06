package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the IdleState of the game. It is a GameState.
 * @param context is the GameController of the game.
 */
class IdleState(context: GameController) extends GameState(context) {
  /**
   * Method that moves the player to the next panel. It is a transition method to the PlayerState.
   */
  override def nextTurn(): Unit = {
    context.state = new PlayerState(context)

  }
}
