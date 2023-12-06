package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/**
 * Class that represents the state of the game when the player is rolling the dice.
 * @param context is the controller of the game.
 */
class PlayerState(context: GameController) extends GameState(context) {
  /**
   * Method that rolls the dice. It is a transition method to the ChoicePanelState.
   */
  override def rollDice(): Unit = {
    context.state = new ChoicePanelState(context)
  }
}
