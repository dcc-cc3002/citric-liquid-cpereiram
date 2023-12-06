package cl.uchile.dcc.citric
package controller.states

import model.character.PlayerCharacter

import cl.uchile.dcc.citric.controller.GameController

/**
 * Class that represents the starting state of the game.
 * @param context The game controller.
 *
 * @constructor Creates a new starting state with the given game controller.
 */
class StartingState(context: GameController) extends GameState(context) {
  /**
   * Method that starts the game.
   * This method should be called when the game start.
   * Must roll the order of the players and set the first player as current.
   */
  override def startGame(): Unit = {
    context.state = new IdleState(context)
  }
}
