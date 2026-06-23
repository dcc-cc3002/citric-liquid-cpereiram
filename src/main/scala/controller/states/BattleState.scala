package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the state of the game when the player is rolling the dice.
 * @param context is the controller of the game.
 */
class BattleState(context: GameController) extends GameState(context) {

  /**
   * Method that ends the turn.
   */
  override def turnEnded(): Unit = {
    context.state = new IdleState(context)
  }
}
